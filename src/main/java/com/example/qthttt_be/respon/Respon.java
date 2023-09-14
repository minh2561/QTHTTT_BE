package com.example.qthttt_be.respon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Respon<T> {
    private String messageCode;
    private T data;

    public Respon(String messageCode) {
        this.messageCode = messageCode;
    }

    public Respon(String messageCode, T data) {
        this.messageCode = messageCode;
        this.data = data;
    }
}
