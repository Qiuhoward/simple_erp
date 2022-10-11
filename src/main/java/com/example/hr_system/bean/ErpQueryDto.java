package com.example.hr_system.bean;

import lombok.Data;

import java.util.Date;

@Data
public class ErpQueryDto {
    private String teacherName;//導師姓名
    private String account;// 帳號
    private boolean isUser; //	是否啟用
    private boolean isPush; //是否推播
    private Date changingTime; //異動時間
    private Long changingPersonnel;// 異動人員
    private String device;//裝置
    private String deleted;//刪除

}

