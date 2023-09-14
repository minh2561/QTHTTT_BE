package com.example.qthttt_be.domain.user.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class RegisterUserRequest {
    private String userName;
    private String passWord;
    private String name;
    private Date dateOfBirth;
    private Boolean sex;
    private String phoneNumber;
    private String email;
    private String address;
    private String position;
    private String idRole;
}
