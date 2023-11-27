package com.joel.springcloud.mscv.course.domain.services;

import com.joel.springcloud.mscv.course.api.dtos.request.UserRequest;
import com.joel.springcloud.mscv.course.api.dtos.response.CourseDTO;
import com.joel.springcloud.mscv.course.api.dtos.response.CourseUserDTO;
import com.joel.springcloud.mscv.course.domain.models.CourseUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CourseUserService {
     Page<CourseDTO> findAll(Pageable pageable);
    Page<CourseDTO> getCourses(UUID userId, UUID courseId, Pageable pageable);
    CourseUserDTO subscribeUserToCourse(UserRequest userRequest, UUID courseId);

    void unsubscribeUserInCourse(UUID userId, UUID courseId);

    CourseUser findCourseUser(UUID userId, UUID courseId);

    Page<CourseDTO> getCoursesByUserId(UUID courseId, UUID userId, Pageable pageable);
}
