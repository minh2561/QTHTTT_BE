package com.example.qthttt_be.Seeder.Enum;

import lombok.Getter;

/**
 * @author Nguyễn Tuấn Minh
 */
public enum RoleEnum {
    USER("ROLE_USER"),
    EMPLOYEE("ROLE_EMPLOYEE"),
    ADMIN("ROLE_ADMIN");;
    @Getter
    private String role;

    RoleEnum(String role) {
        this.role = role;
    }
}
