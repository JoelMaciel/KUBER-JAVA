package org.joel.springcloud.msvc.users.api.clients;

import org.joel.springcloud.msvc.users.api.dtos.request.UserRequestUpdate;
import org.joel.springcloud.msvc.users.api.dtos.response.UserDTO;
import org.joel.springcloud.msvc.users.domain.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@FeignClient(name = "kuber-courses", url = "${kuber-courses.url}")
public interface CourseClient {

    @PostMapping("/api/users")
    UserDTO saveUser(@RequestBody UserDTO userDTO);

    @DeleteMapping("/api/users/{userId}")
    void deleteUser(@PathVariable UUID userId);

    @PutMapping("/api/users/{userId}")
    UserDTO updateUser(@PathVariable UUID userId, @RequestBody @Valid UserRequestUpdate requestUpdate);
}