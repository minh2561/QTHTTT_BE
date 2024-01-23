package com.example.qthttt_be.domain.user.model.req;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class RegisterRequest {
    private String email;
    private String password;
    private String name;
    private Date dateOfBirth;
    private Boolean sex;
    private String phoneNumber;
}
