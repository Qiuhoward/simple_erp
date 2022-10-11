package com.example.hr_system.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
public class TeacherList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;

    private String teacherName;//導師姓名

    private String account;// 帳號

    private boolean isUser;   //是否啟用

    private boolean isPush; //是否推播

    private Date changingTime; //異動時間

    private Long changingPersonnel;// 異動人員

    private String device;//裝置

    private String deleted;//刪除

}
