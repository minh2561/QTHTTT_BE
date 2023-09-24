package com.example.qthttt_be.domain.user.model.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class RegisterUserRequest {

    @NotBlank(message = "Tên người dùng không được để trống")
    private String userName;

    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 8, message = "Mật khẩu phải có ít nhất 8 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Mật khẩu không được chứa ký tự đặc biệt")
    private String passWord;

    @NotBlank(message = "Tên không được để trống")
    private String name;

    @NotNull(message = "Ngày sinh không được null")
    private Date dateOfBirth;

    @NotNull(message = "Giới tính không được null")
    private Boolean sex;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "\\d{10}", message = "Số điện thoại không hợp lệ. Vui lòng nhập 10 số.")
    private String phoneNumber;

    @NotBlank(message = "Email không được để trống")
    @Pattern(regexp = "^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$", message = "Email không hợp lệ")
    private String email;

    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;

    //    @NotBlank(message = "Vị trí không được để trống")
    private String position;

    //    @NotBlank(message = "ID Role không được để trống")
    private String idRole;
}
