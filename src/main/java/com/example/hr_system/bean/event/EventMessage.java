package com.example.hr_system.bean.event;

import lombok.Getter;
import lombok.Setter;

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

    EventMessage<OBJECT>  GetEeceptionMessage(String eventCode,String eventDescription){
        EventMessage<OBJECT> result=new EventMessage<OBJECT>();
        result.setEventCode(eventCode);
        result.setEventDescription(eventDescription);

       return  result;
    }
}
