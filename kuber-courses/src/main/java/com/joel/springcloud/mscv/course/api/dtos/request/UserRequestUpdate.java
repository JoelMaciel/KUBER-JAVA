package com.joel.springcloud.mscv.course.api.dtos.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserRequestUpdate {

    @NotBlank
    private String name;
    @Email
    @NotBlank
    private String email;

}
