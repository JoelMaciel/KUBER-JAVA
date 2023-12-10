package com.joel.springcloud.mscv.course.api.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.joel.springcloud.mscv.course.domain.models.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
public class UserDTO {

    private UUID userId;
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime creationDate;
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime updateDate;

    public static UserDTO toDTO(User user) {
        return UserDTO.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .creationDate(user.getCreationDate())
                .updateDate(user.getUpdateDate())
                .build();
    }



}
