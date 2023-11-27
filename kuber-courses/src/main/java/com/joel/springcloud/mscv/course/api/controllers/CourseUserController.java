package com.joel.springcloud.mscv.course.api.controllers;

import com.joel.springcloud.mscv.course.api.dtos.request.UserRequest;
import com.joel.springcloud.mscv.course.api.dtos.response.CourseDTO;
import com.joel.springcloud.mscv.course.api.dtos.response.CourseUserDTO;
import com.joel.springcloud.mscv.course.domain.services.CourseService;
import com.joel.springcloud.mscv.course.domain.services.CourseUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseUserController {

    private final CourseUserService courseUserService;

    @GetMapping
    public Page<CourseDTO> getAll(
            @RequestParam(value = "userId", required = false) UUID userId,
            @RequestParam(value = "courseId", required = false) UUID courseId,
            @PageableDefault(page = 0, size = 10, sort = "courseId", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return courseUserService.getCoursesByUserId(userId, courseId, pageable);
    }


    @PostMapping("/subscriptions/users/{courseId}")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseUserDTO subscriptionUserAndCourse(@RequestBody @Valid UserRequest userRequest, @PathVariable UUID courseId) {
        return courseUserService.subscribeUserToCourse(userRequest, courseId);
    }

    @DeleteMapping("/users/{userId}/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unsubscribeUserInCourse(@PathVariable UUID userId, @PathVariable UUID courseId) {
        courseUserService.unsubscribeUserInCourse(userId, courseId);
    }

}
