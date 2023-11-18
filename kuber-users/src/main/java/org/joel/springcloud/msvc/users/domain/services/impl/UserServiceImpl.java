package org.joel.springcloud.msvc.users.domain.services.impl;

import lombok.RequiredArgsConstructor;
import org.joel.springcloud.msvc.users.api.dtos.request.UserRequest;
import org.joel.springcloud.msvc.users.api.dtos.request.UserRequestUpdate;
import org.joel.springcloud.msvc.users.api.dtos.response.UserDTO;
import org.joel.springcloud.msvc.users.domain.exceptions.UserNotFoundException;
import org.joel.springcloud.msvc.users.domain.models.User;
import org.joel.springcloud.msvc.users.domain.repositories.UserRepository;
import org.joel.springcloud.msvc.users.domain.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public Page<UserDTO> list(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return users.map(UserDTO::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO findById(Long userId) {
        return UserDTO.toDTO(searchById(userId));
    }

    @Override
    @Transactional
    public UserDTO save(UserRequest userRequest) {
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        User user = UserRequest.toEntity(userRequest);
        return UserDTO.toDTO(userRepository.save(user));
    }

    @Override
    @Transactional
    public UserDTO update(Long userid, UserRequestUpdate request) {
        User user = searchById(userid);
        updateUserDetails(user, request);
        return UserDTO.toDTO(userRepository.save(user));
    }

    @Override
    @Transactional
    public void delete(Long userId) {
        searchById(userId);
        userRepository.deleteById(userId);
    }

    @Override
    public User searchById(Long userid) {
        return userRepository.findById(userid)
                .orElseThrow(() -> new UserNotFoundException(userid));
    }

    private void updateUserDetails(User user, UserRequestUpdate request) {
        user.setName(request.getName());
        user.setEmail(request.getEmail());
    }
}
