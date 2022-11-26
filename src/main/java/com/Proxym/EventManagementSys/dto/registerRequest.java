package com.Proxym.EventManagementSys.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class registerRequest {
    @NotBlank
    private String username;
    @NotEmpty( message = "{email.notempty}")
    private String email;
    private String password;
    private Set<String> roles;

}
