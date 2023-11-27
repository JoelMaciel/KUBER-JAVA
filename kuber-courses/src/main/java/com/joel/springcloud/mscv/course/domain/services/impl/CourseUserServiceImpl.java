package com.joel.springcloud.mscv.course.domain.services.impl;

import com.joel.springcloud.mscv.course.api.clients.UserClient;
import com.joel.springcloud.mscv.course.api.dtos.request.UserRequest;
import com.joel.springcloud.mscv.course.api.dtos.response.CourseDTO;
import com.joel.springcloud.mscv.course.api.dtos.response.CourseUserDTO;
import com.joel.springcloud.mscv.course.domain.exceptions.CourseUserNotFoundException;
import com.joel.springcloud.mscv.course.domain.exceptions.UserAlreadySubscribedException;
import com.joel.springcloud.mscv.course.domain.exceptions.UserNotFoundException;
import com.joel.springcloud.mscv.course.domain.models.Course;
import com.joel.springcloud.mscv.course.domain.models.CourseUser;
import com.joel.springcloud.mscv.course.domain.models.User;
import com.joel.springcloud.mscv.course.domain.repositories.CourseRepository;
import com.joel.springcloud.mscv.course.domain.repositories.CourseUserRepository;
import com.joel.springcloud.mscv.course.domain.services.CourseService;
import com.joel.springcloud.mscv.course.domain.services.CourseUserService;
import com.joel.springcloud.mscv.course.domain.services.UserService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseUserServiceImpl implements CourseUserService {
    public static final String MSG_SUBCRIPTION_CONFLICT = "User is already subscribed to this course.";
    public static final String MSG_COURSE_USER_NOT_FOUND = "There is no user and course relationship";


    private final CourseService courseService;
    private final UserService userService;
    private final CourseRepository courseRepository;
    private final CourseUserRepository courseUserRepository;
    private final UserClient userClient;

    @Override
    @Transactional(readOnly = true)
    public Page<CourseDTO> findAll(Pageable pageable) {
        return courseRepository.findAll(pageable).map(CourseDTO::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CourseDTO> getCourses(UUID userId, UUID courseId, Pageable pageable) {
        if (userId != null) {
            return getCoursesByUserId(userId, courseId, pageable);
        } else {
            return findAll(pageable);
        }
    }

    @Override
    @Transactional
    public CourseUserDTO subscribeUserToCourse(UserRequest userRequest, UUID courseId) {
        User user = userService.userByUserId(userRequest.getUserId());
        validateCourseAndUser(courseId, userRequest.getUserId());

        Course course = courseService.courseById(courseId);
        CourseDTO courseDTO = CourseDTO.toDTO(course);

        CourseUser courseUser = new CourseUser();
        courseUser.setUser(user);
        courseUser.setCourse(course);
        courseUserRepository.save(courseUser);

        return CourseUserDTO.toDTO(courseUser, user, courseDTO);
    }

    @Override
    @Transactional
    public void unsubscribeUserInCourse(UUID userId, UUID courseId) {
        Course course = courseService.courseById(courseId);
        userClient.getOne(userId);

        CourseUser courseUser = findCourseUser(userId, courseId);
        course.removeCourseUser(courseUser);
        courseUserRepository.deleteByUserUserId(userId);
    }

    @Override
    public CourseUser findCourseUser(UUID userId, UUID courseId) {
        return courseUserRepository.findByUserUserIdAndCourseCourseId(userId, courseId)
                .orElseThrow(() -> new CourseUserNotFoundException(MSG_COURSE_USER_NOT_FOUND));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CourseDTO> getCoursesByUserId(UUID courseId, UUID userId, Pageable pageable) {
        if (userId == null) {
            return courseRepository.findAll(pageable).map(CourseDTO::toDTO);
        }

        Page<Course> courses = courseUserRepository.findCoursesByUserId(userId, pageable);
        return courses.map(CourseDTO::toDTO);
    }

    private void validateCourseAndUser(UUID courseId, UUID userId) {
        try {
            Course course = courseService.courseById(courseId);
            userClient.getOne(userId);

            boolean isAlreadySubscribe = course.getCourseUsers()
                    .stream()
                    .anyMatch(courseUser -> courseUser.getUser().getUserId().equals(userId));
            if (isAlreadySubscribe) {
                throw new UserAlreadySubscribedException(MSG_SUBCRIPTION_CONFLICT);
            }
        } catch (FeignException e) {
            throw new UserNotFoundException(userId);
        }

    }
}
