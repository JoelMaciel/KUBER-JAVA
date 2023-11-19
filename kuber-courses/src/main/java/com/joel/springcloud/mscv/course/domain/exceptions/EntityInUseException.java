package com.joel.springcloud.mscv.course.domain.exceptions;

public class EntityInUseException extends BusinessException {
    public EntityInUseException(String message) {
        super(message);
    }
}
