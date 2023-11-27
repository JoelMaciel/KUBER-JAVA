package com.joel.springcloud.mscv.course.api.controllers;


import com.joel.springcloud.mscv.course.api.dtos.request.UserRequestUpdate;
import com.joel.springcloud.mscv.course.api.dtos.response.UserDTO;
import com.joel.springcloud.mscv.course.domain.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserController {

    private final UserService userService;

    @PutMapping("/api/users/{userId}")
    UserDTO updateUser(@PathVariable UUID userId, @RequestBody @Valid UserRequestUpdate userRequestUpdate){
        return userService.update(userId, userRequestUpdate);
    }

    @DeleteMapping("/api/users/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable UUID userId) {
        userService.delete(userId);
    }
}
