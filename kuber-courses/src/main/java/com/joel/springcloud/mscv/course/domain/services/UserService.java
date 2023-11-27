package com.joel.springcloud.mscv.course.domain.services;

import com.joel.springcloud.mscv.course.api.dtos.request.UserRequestUpdate;
import com.joel.springcloud.mscv.course.api.dtos.response.UserDTO;
import com.joel.springcloud.mscv.course.domain.models.User;

import java.util.UUID;

public interface UserService {

    User userByUserId(UUID userId);

    void delete(UUID userId);

    UserDTO update(UUID userId, UserRequestUpdate userRequestUpdate);
}
