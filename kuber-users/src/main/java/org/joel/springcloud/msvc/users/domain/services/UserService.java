package org.joel.springcloud.msvc.users.domain.services;

import org.joel.springcloud.msvc.users.api.dtos.response.UserDTO;
import org.joel.springcloud.msvc.users.api.dtos.request.UserRequest;

import java.util.List;

public interface UserService {

    List<UserDTO> list();
    UserDTO findById(Long id);

    UserDTO save(UserRequest userRequest);
}
