package com.example.qthttt_be.domain.user;

import com.example.qthttt_be.domain.user.model.LoginRequest;
import com.example.qthttt_be.domain.user.model.RegisterUserRequest;
import com.example.qthttt_be.respon.Respon;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Respon register(RegisterUserRequest request);

    Respon login(LoginRequest loginRequest);

    Respon logout();

    Respon getAuthor();
}
