package com.example.qthttt_be.auth;

import com.example.qthttt_be.domain.user.UserRepository;
import com.example.qthttt_be.domain.user.entity.UserEntity;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nguyễn Tuấn Minh
 */
@Component
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);
        Hibernate.initialize(userEntity.getRoleEntity().getRole());
        return new MyUserPrincipal(userEntity);
    }
}
