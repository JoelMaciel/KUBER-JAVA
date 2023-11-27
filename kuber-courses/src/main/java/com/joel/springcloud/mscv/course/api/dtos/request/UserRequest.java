package com.joel.springcloud.mscv.course.api.dtos.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class UserRequest {

    @NotNull
    private UUID userId;
}
