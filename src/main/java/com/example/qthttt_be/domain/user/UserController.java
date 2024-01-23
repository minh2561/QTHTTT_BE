package com.example.qthttt_be.domain.user;

import com.example.qthttt_be.domain.user.model.req.LoginRequest;
import com.example.qthttt_be.domain.user.model.req.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nguyễn Tuấn Minh
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequest registerUserRequest) {
        return ResponseEntity.ok(userService.register(registerUserRequest));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    @GetMapping("/logout")
    public ResponseEntity logout() {
        return ResponseEntity.ok(userService.logout());
    }

    @GetMapping("/get-author")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity getAuthor() {
        return ResponseEntity.ok(userService.getAuthor());
    }

    @GetMapping("/minh")
    public ResponseEntity get() {
        return ResponseEntity.ok(userService.getMinh());
    }
}