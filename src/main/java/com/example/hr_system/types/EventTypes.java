package com.example.hr_system.types;
import lombok.Getter;
import lombok.ToString;

/**
 * 錯誤碼管理.
 */
@ToString
@Getter
public enum EventTypes {

    /** 完成請求. */
    DONE("0000", "DONE"),
    /** 登入 - 帳號或密碼為空. */
    LOGIN_ACCOUNT_OR_PASSWORD_EMPTY_ERROR("0001", "LOGIN_ACCOUNT_PASSWORD_EMPTY."),
    /** 登入 - 找不到此使用者帳號. */
    LOGIN_ACCOUNT_USER_NOTFOUND_ERROR("0002", "LOGIN_USER_NOT_FOUND.");


    /** 事件代號. */

    private final String eventCode;
    /** 事件描述. */
    private final String eventDescription;

    EventTypes(String eventCode, String eventDescription) {
        this.eventCode = eventCode;
        this.eventDescription = eventDescription;
    }

    }
