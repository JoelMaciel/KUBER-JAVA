package com.joel.springcloud.mscv.course.domain.exceptions;

public class CourseAlreadyExistsException extends EntityInUseException{
    public CourseAlreadyExistsException(String message) {
        super(message);
    }

}
