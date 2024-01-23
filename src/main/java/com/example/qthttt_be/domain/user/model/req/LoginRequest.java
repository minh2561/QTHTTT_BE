package com.example.qthttt_be.domain.user.model.req;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Nguyễn Tuấn Minh
 */
@Getter
@Setter
public class LoginRequest {
    private String email;
    private String password;
}
