package com.joel.springcloud.mscv.course.api.clients;

import com.joel.springcloud.mscv.course.api.dtos.response.CourseDTO;
import com.joel.springcloud.mscv.course.domain.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "kuber-users", url = "localhost:8001")
public interface UserClient {

    @GetMapping("/api/users/{userId}")
    User getOne(@PathVariable UUID userId);

    @PostMapping("/api/users")
    User saveUser(@RequestBody User user);

    @GetMapping("/api/users/{userId}/courses")
    Page<CourseDTO> gelAllCourseOfUser(@PageableDefault(page = 0, size = 10, sort = "courseId",
                 direction = Sort.Direction.ASC) Pageable pageable, @PathVariable UUID userId);
}
