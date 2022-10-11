package com.example.hr_system.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@ToString
public class UserPermissionList {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userPermissionListId;
    private long userId;
    private long targetId;

}