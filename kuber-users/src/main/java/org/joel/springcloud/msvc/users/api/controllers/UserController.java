package org.joel.springcloud.msvc.users.api.controllers;

import lombok.RequiredArgsConstructor;
import org.joel.springcloud.msvc.users.api.dtos.request.UserRequest;
import org.joel.springcloud.msvc.users.api.dtos.request.UserRequestUpdate;
import org.joel.springcloud.msvc.users.api.dtos.response.UserDTO;
import org.joel.springcloud.msvc.users.domain.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public Page<UserDTO> gelAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)
                                Pageable pageable) {
        return userService.list(pageable);
    }

    @GetMapping("/{userId}")
    public UserDTO getOne(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO saveUser(@RequestBody @Valid UserRequest userRequest) {
        return userService.save(userRequest);
    }

    @PutMapping("/{userId}")
    public UserDTO updateUser(@PathVariable Long userId, @RequestBody @Valid UserRequestUpdate requestUpdate) {
        return userService.update(userId, requestUpdate);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long userId) {
        userService.delete(userId);
    }

}
