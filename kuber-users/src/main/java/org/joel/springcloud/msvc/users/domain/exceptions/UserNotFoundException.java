package org.joel.springcloud.msvc.users.domain.exceptions;

public class UserNotFoundException extends EntityNotExistsException{
    public UserNotFoundException(Long userId) {
        super(String.format("Nao existe um  user com este id : ", userId));
    }
}
