package com.joel.springcloud.mscv.course.domain.exceptions;

import java.util.UUID;

public class UserNotFoundException extends EntityNotExistsException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(UUID userId) {
        this(String.format("There is no user with this uuid %s ", userId));
    }

}
