package org.joel.springcloud.msvc.users.api.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.joel.springcloud.msvc.users.domain.models.User;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
public class UserDTO {

    private UUID userId;
    private String name;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime creationDate;
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
