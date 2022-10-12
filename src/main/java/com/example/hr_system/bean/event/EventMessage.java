package com.example.hr_system.bean.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 事件訊息.
 *
 * @author luke
 */
public class EventMessage<OBJECT> {
    @Getter @Setter private String eventCode;
    @Getter @Setter private String eventDescription;
    /** 事件訊息. */
    @Getter @Setter private OBJECT eventMessage;



    public EventMessage<OBJECT>  GetEeceptionMessage(String eventCode, String eventDescription){
        EventMessage<OBJECT> result=new EventMessage<OBJECT>();
        result.setEventCode(eventCode);
        result.setEventDescription(eventDescription);

        return  result;
    }

    public <OBJECT> EventMessage<OBJECT> setDefaultEventMessage(OBJECT data) {
        EventMessage<OBJECT> result = new EventMessage<OBJECT>();
        result.setEventCode("0000");
        result.setEventDescription("成功執行");
        result.setEventMessage(data);
        return result;
    }
}



