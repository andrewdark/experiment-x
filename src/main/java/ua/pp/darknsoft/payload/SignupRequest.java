package ua.pp.darknsoft.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ua.pp.darknsoft.utils.EqualPasswords;

import javax.management.ConstructorParameters;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@EqualPasswords
public class SignupRequest {

    @NotBlank
    @Size(min = 2, max = 36)
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9-_\\.]{2,36}$")
    private String username;

    @NotBlank
    @Size(min = 8, max = 128)
    //@Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")
    @Pattern(regexp = "^(?=.{8,32}$)(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$]).*")
    private String password;


    private String confirmedPassword;
}

