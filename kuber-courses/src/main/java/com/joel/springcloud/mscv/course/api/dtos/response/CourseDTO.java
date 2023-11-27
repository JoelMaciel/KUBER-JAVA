package com.joel.springcloud.mscv.course.api.dtos.response;

import com.joel.springcloud.mscv.course.domain.models.Course;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class CourseDTO {

    private UUID courseId;
    private String name;
    private OffsetDateTime creationDate;
    private OffsetDateTime updateDate;

    public static CourseDTO toDTO(Course course) {
        return CourseDTO.builder()
                .courseId(course.getCourseId())
                .name(course.getName())
                .creationDate(course.getCreationDate())
                .updateDate(course.getUpdateDate())
                .build();
    }
}
