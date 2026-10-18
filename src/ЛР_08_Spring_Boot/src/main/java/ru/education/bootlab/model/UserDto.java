package ru.education.bootlab.model;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class UserDto {
 @NotBlank @Size(max=50) private String firstName;
 @NotBlank @Size(max=50) private String lastName;
 @NotBlank @Email @Size(max=254) private String email;
 @NotBlank @Size(min=8,max=72) private String password;
}
