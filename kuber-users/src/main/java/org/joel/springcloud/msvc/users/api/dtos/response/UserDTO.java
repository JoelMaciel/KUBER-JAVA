package org.joel.springcloud.msvc.users.api.dtos.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.joel.springcloud.msvc.users.domain.models.User;

import java.time.OffsetDateTime;

@Builder
@Getter
@Setter
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private OffsetDateTime creationDate;
    private OffsetDateTime updateDate;

    public static UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .creationDate(user.getCreationDate())
                .updateDate(user.getUpdateDate())
                .build();
    }
}
