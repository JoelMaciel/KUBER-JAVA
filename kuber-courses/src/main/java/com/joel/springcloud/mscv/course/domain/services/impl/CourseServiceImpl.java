package com.joel.springcloud.mscv.course.domain.services.impl;

import com.joel.springcloud.mscv.course.api.dtos.request.CourseRequest;
import com.joel.springcloud.mscv.course.api.dtos.response.CourseDTO;
import com.joel.springcloud.mscv.course.domain.exceptions.CourseAlreadyExistsException;
import com.joel.springcloud.mscv.course.domain.exceptions.CourseNotFoundException;
import com.joel.springcloud.mscv.course.domain.models.Course;
import com.joel.springcloud.mscv.course.domain.repositories.CourseRepository;
import com.joel.springcloud.mscv.course.domain.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    public static final String MSG_COURSE_ALREADY_EXISTS = "There is a Course registered with that name";
    private final CourseRepository courseRepository;

    @Override
    @Transactional(readOnly = true)
    public CourseDTO findById(UUID courseId) {
        return CourseDTO.toDTO(courseById(courseId));
    }

    @Override
    @Transactional
    public CourseDTO save(CourseRequest courseRequest) {
        validateCourse(courseRequest.getName());
        return CourseDTO.toDTO(courseRepository.save(CourseRequest.toEntity(courseRequest)));
    }

    @Override
    @Transactional
    public CourseDTO update(UUID courseId, CourseRequest courseRequest) {
        Course course = courseById(courseId);
        validateCourse(courseRequest.getName());
        course.setName(courseRequest.getName());
        return CourseDTO.toDTO(courseRepository.save(course));
    }

    @Override
    @Transactional
    public void delete(UUID courseId) {
        courseById(courseId);
        courseRepository.deleteById(courseId);

    }

    @Override
    public boolean validateCourse(String name) {
        if (courseRepository.existsByName(name)) {
            throw new CourseAlreadyExistsException(MSG_COURSE_ALREADY_EXISTS);
        }
        return false;
    }

    @Override
    public Course courseById(UUID courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(courseId));
    }

}
