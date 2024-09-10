package com.rcm.info.wallet.api.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Data
public class UserDTO {

    private Long id;

    @Length(min = 3, max = 50, message = "O Nome deve conter entre 3 e 50 caracteres")
    private String name;

    @Email(message = "Email inválido")
    private String email;

    @NotNull
    @Length(min = 6, message = "A senha deve conter no mínimo 6 caracteres")
    private String password;
}
