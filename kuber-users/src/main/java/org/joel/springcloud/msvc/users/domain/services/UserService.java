package org.joel.springcloud.msvc.users.domain.services;

import org.joel.springcloud.msvc.users.api.dtos.request.UserRequest;
import org.joel.springcloud.msvc.users.api.dtos.request.UserRequestUpdate;
import org.joel.springcloud.msvc.users.api.dtos.response.UserDTO;
import org.joel.springcloud.msvc.users.domain.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<UserDTO> list(Pageable pageable);

    UserDTO findById(Long id);

    UserDTO save(UserRequest userRequest);
    UserDTO update(Long userid, UserRequestUpdate request);

    void delete(Long id);

    User searchById(Long id);
}
