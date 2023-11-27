package com.joel.springcloud.mscv.course.api.dtos.response;

import com.joel.springcloud.mscv.course.domain.models.CourseUser;
import com.joel.springcloud.mscv.course.domain.models.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class CourseUserDTO {

    private UUID id;
    private String courseName;
    private User user;

    public static CourseUserDTO toDTO(CourseUser courseUser, User user, CourseDTO courseDTO) {
        return CourseUserDTO.builder()
                .id(courseUser.getId())
                .user(user)
                .courseName(courseDTO.getName())
                .build();

    }
}
