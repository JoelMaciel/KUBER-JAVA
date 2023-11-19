package com.joel.springcloud.mscv.course.domain.services;

import com.joel.springcloud.mscv.course.api.dtos.request.CourseRequest;
import com.joel.springcloud.mscv.course.api.dtos.response.CourseDTO;
import com.joel.springcloud.mscv.course.domain.models.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {
    Page<CourseDTO> findALl(Pageable pageable);

    CourseDTO findById(Long courseId);

    CourseDTO save(CourseRequest courseRequest);

    CourseDTO update(Long courseId, CourseRequest courseRequest);

    void delete(Long courseId);

    Course searchById(Long id);
}
