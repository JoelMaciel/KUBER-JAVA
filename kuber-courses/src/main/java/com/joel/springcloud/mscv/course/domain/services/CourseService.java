package com.joel.springcloud.mscv.course.domain.services;

import com.joel.springcloud.mscv.course.api.dtos.request.CourseRequest;
import com.joel.springcloud.mscv.course.api.dtos.response.CourseDTO;
import com.joel.springcloud.mscv.course.domain.models.Course;

import java.util.UUID;

public interface CourseService {

    CourseDTO findById(UUID courseId);

    CourseDTO save(CourseRequest courseRequest);

    CourseDTO update(UUID courseId, CourseRequest courseRequest);

    void delete(UUID courseId);

    boolean validateCourse(String name);

    Course courseById(UUID courseId);

}
