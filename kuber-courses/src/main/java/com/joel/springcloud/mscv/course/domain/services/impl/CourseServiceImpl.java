package com.joel.springcloud.mscv.course.domain.services.impl;

import com.joel.springcloud.mscv.course.api.dtos.request.CourseRequest;
import com.joel.springcloud.mscv.course.api.dtos.response.CourseDTO;
import com.joel.springcloud.mscv.course.domain.exceptions.CourseAlreadyExistsException;
import com.joel.springcloud.mscv.course.domain.exceptions.CourseNotFoundException;
import com.joel.springcloud.mscv.course.domain.models.Course;
import com.joel.springcloud.mscv.course.domain.repositories.CourseRepository;
import com.joel.springcloud.mscv.course.domain.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    public static final String MSG_COURSE_ALREADY_EXISTS = "There is a Course registered with that name";
    private final CourseRepository courseRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<CourseDTO> findAll(Pageable pageable) {
        return courseRepository.findAll(pageable).map(CourseDTO::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public CourseDTO findById(Long courseId) {
        return CourseDTO.toDTO(searchById(courseId));
    }

    @Override
    @Transactional
    public CourseDTO save(CourseRequest courseRequest) {
        validateCourse(courseRequest.getName());
        return CourseDTO.toDTO(courseRepository.save(CourseRequest.toEntity(courseRequest)));
    }

    @Override
    @Transactional
    public CourseDTO update(Long courseId, CourseRequest courseRequest) {
        Course course = searchById(courseId);
        validateCourse(courseRequest.getName());
        course.setName(courseRequest.getName());
        return CourseDTO.toDTO(courseRepository.save(course));
    }

    @Override
    @Transactional
    public void delete(Long courseId) {
        searchById(courseId);
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
    public Course searchById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(courseId));
    }
}
