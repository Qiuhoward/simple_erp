package com.example.hr_system.bean.login;

import lombok.Data;

@Data
public class LoginGetDto {

    private  int    loginId;
    private  String loginAccount;
    private  String password;
    private  int    peopleId;

}
