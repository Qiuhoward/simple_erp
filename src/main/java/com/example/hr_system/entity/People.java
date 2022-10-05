package com.example.hr_system.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Data
@Entity
public class People {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int peopleId;
    private  String peoplePosition;
    private  String name;
    private  String gender;
    private  Date birth;
    private  int  cellphoneNumber;
    private  String email;
    private String permission;
}

//人員id	職位	姓名	性別	生日	 電子郵件 電話