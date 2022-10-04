package com.example.hr_system.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loginId;

    private String account;
    private String passeord;
    private int peopleNumber;
}


//login_Id	帳號	密碼	人員編號
