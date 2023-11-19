package org.joel.springcloud.msvc.users.domain.exceptions;

public class UserNotFoundException extends EntityNotExistsException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Long userId) {
        this(String.format("There is no user with this id %s:", userId));
    }

}
