package com.joel.springcloud.mscv.course.domain.exceptions;

public class UserAlreadySubscribedException extends EntityInUseException{
    public UserAlreadySubscribedException(String message) {
        super(message);
    }
}
