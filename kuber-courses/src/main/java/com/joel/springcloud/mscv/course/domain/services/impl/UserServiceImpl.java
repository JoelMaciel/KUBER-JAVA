package com.joel.springcloud.mscv.course.domain.services.impl;

import com.joel.springcloud.mscv.course.api.dtos.request.UserRequestUpdate;
import com.joel.springcloud.mscv.course.api.dtos.response.UserDTO;
import com.joel.springcloud.mscv.course.domain.exceptions.UserNotFoundException;
import com.joel.springcloud.mscv.course.domain.models.User;
import com.joel.springcloud.mscv.course.domain.repositories.UserRepository;
import com.joel.springcloud.mscv.course.domain.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO save(UserDTO userDTO) {
        userRepository.save(User.toEntity(userDTO));
        return userDTO;
    }

    @Override
    @Transactional
    public void delete(UUID userId) {
        userByUserId(userId);
        userRepository.deleteById(userId);
    }

    @Override
    @Transactional
    public UserDTO update(UUID userId, UserRequestUpdate userRequestUpdate) {
        User user = userByUserId(userId);
        user.setName(userRequestUpdate.getName());
        user.setEmail(userRequestUpdate.getEmail());
        return UserDTO.toDTO(userRepository.save(user));
    }

    @Override
    @Transactional(readOnly = true)
    public User userByUserId(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }
}
