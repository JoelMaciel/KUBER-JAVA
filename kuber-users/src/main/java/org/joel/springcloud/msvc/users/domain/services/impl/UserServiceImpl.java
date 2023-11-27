package org.joel.springcloud.msvc.users.domain.services.impl;

import lombok.RequiredArgsConstructor;
import org.joel.springcloud.msvc.users.api.clients.CourseClient;
import org.joel.springcloud.msvc.users.api.dtos.request.UserRequest;
import org.joel.springcloud.msvc.users.api.dtos.request.UserRequestUpdate;
import org.joel.springcloud.msvc.users.api.dtos.response.UserDTO;
import org.joel.springcloud.msvc.users.domain.exceptions.EmailAlreadyExistsException;
import org.joel.springcloud.msvc.users.domain.exceptions.UserNotFoundException;
import org.joel.springcloud.msvc.users.domain.models.User;
import org.joel.springcloud.msvc.users.domain.repositories.UserRepository;
import org.joel.springcloud.msvc.users.domain.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    public static final String MSG_EMAIL_CONFLICT = "There is already a registered user with this email";
    private final UserRepository userRepository;
    private final CourseClient courseClient;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public Page<UserDTO> list(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return users.map(UserDTO::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO findById(UUID userId) {
        return UserDTO.toDTO(searchById(userId));
    }

    @Override
    @Transactional
    public UserDTO save(UserRequest userRequest) {
        validateEmail(userRequest.getEmail());
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        User user = UserRequest.toEntity(userRequest);
        return UserDTO.toDTO(userRepository.save(user));
    }

    @Override
    @Transactional
    public UserDTO update(UUID userId, UserRequestUpdate request) {
        User user = searchById(userId);
        validateEmail(request.getEmail());
        updateUserDetails(user, request);
        courseClient.updateUser(userId, request);
        return UserDTO.toDTO(userRepository.save(user));
    }

    @Override
    @Transactional
    public void delete(UUID userId) {
        searchById(userId);
        courseClient.deleteUser(userId);
        userRepository.deleteById(userId);
    }

    @Override
    public User searchById(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    private void updateUserDetails(User user, UserRequestUpdate request) {
        user.setName(request.getName());
        user.setEmail(request.getEmail());
    }

    private void validateEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistsException(MSG_EMAIL_CONFLICT);
        }
    }
}