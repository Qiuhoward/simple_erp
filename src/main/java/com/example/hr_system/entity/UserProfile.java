package com.example.hr_system.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Getter
@Setter
@Entity
@ToString
public class UserProfile {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long  userProfileId ;
    private Long userId;
    private  String name;
    private  String gender;
    private  Date birthday;
    private  String  cellphoneNumber;
    private String companyId;
}
