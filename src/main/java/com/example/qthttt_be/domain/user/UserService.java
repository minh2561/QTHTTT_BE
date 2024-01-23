package com.example.qthttt_be.domain.user;

import com.example.qthttt_be.domain.user.model.req.LoginRequest;
import com.example.qthttt_be.domain.user.model.req.RegisterRequest;
import com.example.qthttt_be.respon.Respon;
import org.springframework.stereotype.Service;

/**
 * @author Nguyễn Tuấn Minh
 */
@Service
public interface UserService {
    Respon register(RegisterRequest request);

    Respon login(LoginRequest loginRequest);

    Respon logout();

    Respon getAuthor();

    Respon getMinh();
}
