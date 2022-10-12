package com.example.hr_system.bean;

import lombok.Data;

import java.util.Date;

@Data
public class AddDto {
    private  String account;
    private  String password1;
    private  String password2;
    private  String email;
    private  String name;
    private  String gender;
    private  Date birthday;
    private  String  cellphoneNumber;
}
