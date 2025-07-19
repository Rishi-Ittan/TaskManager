package com.kasa.task_manager.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginRequest extends UserDto {
    @NotBlank
    @Size(min = 4, max = 20)
    String username;
    @NotBlank
    @Size(min = 6, max = 20)
    String password;
}
