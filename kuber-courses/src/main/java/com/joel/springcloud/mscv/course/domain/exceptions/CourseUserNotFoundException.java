package com.joel.springcloud.mscv.course.domain.exceptions;

public class CourseUserNotFoundException extends EntityInUseException{
    public CourseUserNotFoundException(String message) {
        super(message);
    }

}
