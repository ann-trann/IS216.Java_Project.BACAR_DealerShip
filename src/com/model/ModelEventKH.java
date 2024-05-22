package com.model;

import com.event.EventKH;

public class ModelEventKH {
    
    private ModelKhachHang data;
    private EventKH event;

    public ModelKhachHang getData() {
        return data;
    }

    public void setData(ModelKhachHang data) {
        this.data = data;
    }

    public EventKH getEvent() {
        return event;
    }

    public void setEvent(EventKH event) {
        this.event = event;
    }

    public ModelEventKH(ModelKhachHang data, EventKH event) {
        this.data = data;
        this.event = event;
    }

    public ModelEventKH() {
    }
    
}
