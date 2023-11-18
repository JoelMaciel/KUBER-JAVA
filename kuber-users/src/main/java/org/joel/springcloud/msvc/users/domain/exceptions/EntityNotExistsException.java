package org.joel.springcloud.msvc.users.domain.exceptions;

public class EntityNotExistsException extends BusinessException{
    public EntityNotExistsException(String message) {
        super(message);
    }
}
