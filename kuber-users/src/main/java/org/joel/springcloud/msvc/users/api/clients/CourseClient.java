package org.joel.springcloud.msvc.users.api.clients;

import org.joel.springcloud.msvc.users.api.dtos.request.UserRequestUpdate;
import org.joel.springcloud.msvc.users.api.dtos.response.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.UUID;

@FeignClient(name = "kuber-courses", url = "localhost:8002")
public interface CourseClient {

    @DeleteMapping("/api/users/{userId}")
    void deleteUser(@PathVariable UUID userId);

    @PutMapping("/api/users/{userId}")
    UserDTO updateUser(@PathVariable UUID userId, @RequestBody @Valid UserRequestUpdate requestUpdate);
}