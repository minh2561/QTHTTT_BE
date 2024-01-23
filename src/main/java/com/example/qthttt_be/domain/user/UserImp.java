package com.example.qthttt_be.domain.user;

import com.example.qthttt_be.Seeder.Enum.RoleEnum;
import com.example.qthttt_be.auth.JwtUtility;
import com.example.qthttt_be.domain.user.entity.UserEntity;
import com.example.qthttt_be.domain.user.model.req.LoginRequest;
import com.example.qthttt_be.domain.user.model.req.RegisterRequest;
import com.example.qthttt_be.domain.user.model.res.RegisterRes;
import com.example.qthttt_be.respon.Respon;
import com.example.qthttt_be.respon.ResponError;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

@Component
public class UserImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private JwtUtility jwtUtility;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private HttpServletResponse httpServletResponse;

    @Override
    public Respon register(RegisterRequest registerUserRequest) {
        if (userRepository.findByEmail(registerUserRequest.getEmail()) != null) {
            throw new ResponError(new Respon<>("Đăng kí thất bại"));
        }
        UserEntity userEntity = modelMapper.map(registerUserRequest, UserEntity.class);
        userEntity.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));
        userEntity.setRoleEntity(roleRepository.findByRole(RoleEnum.USER.getRole()));
        userRepository.save(userEntity);
        return new Respon<>("Đăng kí thành công");
    }

    @Override
    public Respon login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtility.generateToken(loginRequest.getEmail());
        UserEntity userEntity = userRepository.findByUserName(loginRequest.getEmail());
//        if (userEntity.getToken() == null) {
            userEntity.setToken(token);
            userRepository.save(userEntity);

            RegisterRes registerRes = new RegisterRes();
            registerRes.setToken(token);
            return new Respon<>("Đăng nhập thành công", registerRes);
//        }
//        throw new ResponError(new Respon<>("Đăng nhập thất bại"));


    }

    @Override
    public Respon logout() {
        UserEntity userEntity = userRepository.findByUserName(jwtUtility.userDetails().getUsername());
        userEntity.setToken(null);
        userRepository.save(userEntity);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, authentication);
        return new Respon<>("Đăng xuất thành công");
    }

    @Override
    public Respon getAuthor() {
        UserEntity userEntity = userRepository.findByUserName(jwtUtility.userDetails().getUsername());
        String token = jwtUtility.parseJwt(httpServletRequest);
        if (userEntity.getToken().equals(token)) {
            return new Respon<>("Lấy dữ liệu thành công");
        }
        throw new ResponError(new Respon<>("Lấy dữ liệu thất bại"));
    }

    @Override
    public Respon getMinh() {
        return new Respon<>("chay duoc roi");
    }
}