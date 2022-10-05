package com.example.hr_system.bean.login;

import lombok.Data;

@Data
public class PasswordEditDto {
    private  int loginId;
    private  String oldPassword;
    private  String newPassword1;
    private  String newPassword2;
}
