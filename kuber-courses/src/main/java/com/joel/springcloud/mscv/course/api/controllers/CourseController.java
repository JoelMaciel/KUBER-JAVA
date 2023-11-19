package com.joel.springcloud.mscv.course.api.controllers;

import com.joel.springcloud.mscv.course.api.dtos.request.CourseRequest;
import com.joel.springcloud.mscv.course.api.dtos.response.CourseDTO;
import com.joel.springcloud.mscv.course.domain.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public Page<CourseDTO> getAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)
                                  Pageable pageable) {
        return courseService.findAll(pageable);
    }

    @GetMapping("/{courseId}")
    public CourseDTO getOne(@PathVariable Long courseId) {
        return courseService.findById(courseId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO save(@RequestBody @Valid CourseRequest courseRequest) {
        return courseService.save(courseRequest);
    }

    @PutMapping("/{courseId}")
    public CourseDTO update(@PathVariable Long courseId, @RequestBody @Valid CourseRequest courseRequest) {
        return courseService.update(courseId, courseRequest);
    }

    @DeleteMapping("/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long courseId) {
        courseService.delete(courseId);
    }
}
