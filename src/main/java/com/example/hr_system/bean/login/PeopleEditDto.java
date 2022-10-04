package com.example.hr_system.bean.login;

import lombok.Data;

import java.util.Date;
@Data
public class PeopleEditDto {

    private  int loginId;
    private  int peopleId;
    private  String peoplePosition;
    private  String name;
    private  String gender;
    private Date birth;
    private  int  cellphoneNumber;
    private  String email;
}
