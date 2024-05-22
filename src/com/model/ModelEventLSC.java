package com.model;

import com.event.EventLSC;

public class ModelEventLSC {
    private ModelLichSuaChua data;
    private EventLSC event;

    public ModelLichSuaChua getData() {
        return data;
    }

    public void setData(ModelLichSuaChua data) {
        this.data = data;
    }

    public EventLSC getEvent() {
        return event;
    }

    public void setEvent(EventLSC event) {
        this.event = event;
    }

    public ModelEventLSC() {
    }

    public ModelEventLSC(ModelLichSuaChua data, EventLSC event) {
        this.data = data;
        this.event = event;
    }
    
}
