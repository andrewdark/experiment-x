package ua.pp.darknsoft.payload;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class SigninRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
