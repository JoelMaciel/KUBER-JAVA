package com.joel.springcloud.mscv.course.domain.exceptions;

import java.util.UUID;

public class CourseNotFoundException extends EntityNotExistsException {
    public CourseNotFoundException(String message) {
        super(message);
    }

    public CourseNotFoundException(UUID courseId) {
        this(String.format("There is no course with this id %s:", courseId));
    }

}
