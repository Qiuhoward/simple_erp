package com.example.hr_system.bean.event;

import com.example.hr_system.types.EventTypes;
import lombok.Getter;
import lombok.Setter;


public class EventMessage<OBJECT> {
    @Getter @Setter private String eventCode;
    @Getter @Setter private String eventDescription;
    /** 事件訊息. */
    @Getter @Setter private OBJECT eventMessage;

    public EventMessage(EventTypes eventType, OBJECT eventMessage){
        this.setEventType(eventType);
        this.setEventMessage(eventMessage);
    }

    public void setEventType(EventTypes eventType) {
        this.eventCode = eventType.getEventCode();
        this.eventDescription = eventType.getEventDescription();
    }
}


