package com.joel.springcloud.mscv.course.domain.services;

import com.joel.springcloud.mscv.course.api.dtos.request.CourseRequest;
import com.joel.springcloud.mscv.course.api.dtos.response.CourseDTO;
import com.joel.springcloud.mscv.course.domain.models.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {
    Page<CourseDTO> findAll(Pageable pageable);

    CourseDTO findById(Long courseId);

    CourseDTO save(CourseRequest courseRequest);

    CourseDTO update(Long courseId, CourseRequest courseRequest);

    void delete(Long courseId);

    boolean validateCourse(String name);

    Course searchById(Long id);
}
