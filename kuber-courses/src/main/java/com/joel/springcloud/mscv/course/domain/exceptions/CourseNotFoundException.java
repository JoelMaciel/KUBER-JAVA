package com.joel.springcloud.mscv.course.domain.exceptions;

public class CourseNotFoundException extends EntityNotExistsException {
    public CourseNotFoundException(String message) {
        super(message);
    }

    public CourseNotFoundException(Long courseId) {
        this(String.format("There is no course with this id %s:", courseId));
    }

}
