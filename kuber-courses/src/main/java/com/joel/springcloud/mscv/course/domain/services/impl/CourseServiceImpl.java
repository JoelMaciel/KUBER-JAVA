package com.joel.springcloud.mscv.course.domain.services.impl;

import com.joel.springcloud.mscv.course.api.dtos.request.CourseRequest;
import com.joel.springcloud.mscv.course.api.dtos.response.CourseDTO;
import com.joel.springcloud.mscv.course.domain.exceptions.CourseNotFoundException;
import com.joel.springcloud.mscv.course.domain.models.Course;
import com.joel.springcloud.mscv.course.domain.repositories.CourseRepository;
import com.joel.springcloud.mscv.course.domain.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<CourseDTO> findALl(Pageable pageable) {
        Page<Course> coursePage = courseRepository.findAll(pageable);
        return coursePage.map(CourseDTO::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public CourseDTO findById(Long courseId) {
        return CourseDTO.toDTO(searchById(courseId));
    }

    @Override
    @Transactional
    public CourseDTO save(CourseRequest courseRequest) {
        Course course = CourseRequest.toEntity(courseRequest);
        return CourseDTO.toDTO(courseRepository.save(course));
    }

    @Override
    @Transactional
    public CourseDTO update(Long courseId, CourseRequest courseRequest) {
        Course course = searchById(courseId);
        course.setName(course.getName());
        return CourseDTO.toDTO(courseRepository.save(course));
    }

    @Override
    @Transactional
    public void delete(Long courseId) {
        searchById(courseId);
        courseRepository.deleteById(courseId);

    }

    @Override
    public Course searchById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(courseId));
    }
}
