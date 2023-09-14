package com.example.qthttt_be.Seeder.Enum;

import lombok.Getter;

public enum PositionEnum {
    USER("USER"),
    EMPLOYEE("EMPLOYEE"),
    ADMIN("ADMIN");;
    @Getter
    private String position;

    PositionEnum(String position) {
        this.position = position;
    }
}