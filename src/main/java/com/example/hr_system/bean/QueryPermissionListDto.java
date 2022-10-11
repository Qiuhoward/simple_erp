package com.example.hr_system.bean;

import lombok.Data;

@Data
public class QueryPermissionListDto {
    private long userId;
    private String name;
    private String companyId;
    private String cellphoneNumber;
}
