package com.joel.springcloud.mscv.course.api.controllers;

import com.joel.springcloud.mscv.course.api.dtos.request.CourseRequest;
import com.joel.springcloud.mscv.course.api.dtos.response.CourseDTO;
import com.joel.springcloud.mscv.course.domain.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/{courseId}")
    public CourseDTO getOne(@PathVariable UUID courseId) {
        return courseService.findById(courseId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO save(@RequestBody @Valid CourseRequest courseRequest) {
        return courseService.save(courseRequest);
    }

    @PutMapping("/{courseId}")
    public CourseDTO update(@PathVariable UUID courseId, @RequestBody @Valid CourseRequest courseRequest) {
        return courseService.update(courseId, courseRequest);
    }

    @DeleteMapping("/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID courseId) {
        courseService.delete(courseId);
    }


}
