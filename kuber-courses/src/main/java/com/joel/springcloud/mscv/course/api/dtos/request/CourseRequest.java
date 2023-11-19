package com.joel.springcloud.mscv.course.api.dtos.request;

import com.joel.springcloud.mscv.course.domain.models.Course;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;

@Getter
@Setter
public class CourseRequest {

    @NotBlank
    private String name;

    public static Course toEntity(CourseRequest request) {
        return Course.builder()
                .name(request.getName())
                .updateDate(OffsetDateTime.now())
                .build();
    }
}
