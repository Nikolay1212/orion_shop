package com.orion.shop.form;

import com.orion.shop.validation.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpForm {

    @Size(min = 3, max = 15, message = "{error.firstName.size}")
    private String firstName;

    @Size(min = 3, max = 15, message = "{error.firstName.size}")
    private String lastName;

    @Email(message = "{error.email.format}")
    private String email;

    @ValidPassword(message = "{error.password.format}")
    @NotEmpty(message = "{error.password.empty}")
    private String password;
}
