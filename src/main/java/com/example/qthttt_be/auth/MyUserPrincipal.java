package com.example.qthttt_be.auth;

import com.example.qthttt_be.domain.user.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@Component
@Getter
public class MyUserPrincipal implements UserDetails {
    private UserEntity userEntity;

    public MyUserPrincipal(UserEntity userEntity) {
        this.userEntity = userEntity;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userEntity.getRoleEntity().getRole()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return userEntity.getPassWord();
    }

    @Override
    public String getUsername() {
        return userEntity.getUserName();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}