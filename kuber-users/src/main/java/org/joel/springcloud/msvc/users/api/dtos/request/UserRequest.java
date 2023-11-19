package org.joel.springcloud.msvc.users.api.dtos.request;

import lombok.Getter;
import lombok.Setter;
import org.joel.springcloud.msvc.users.domain.models.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserRequest {

    @NotBlank
    private String name;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public static User toEntity(UserRequest request) {
        return User.builder()
                .name(request.getName())
                .email(request.email)
                .password(request.getPassword())
                .build();
    }
}
