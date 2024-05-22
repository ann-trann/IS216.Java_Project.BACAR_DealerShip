package com.model;

import com.event.EventNV;

public class ModelEventNV {
    
    private ModelNhanVien nhanVien;
    private EventNV event;

    public ModelNhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(ModelNhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public EventNV getEvent() {
        return event;
    }

    public void setEvent(EventNV event) {
        this.event = event;
    }

    public ModelEventNV(ModelNhanVien nhanVien, EventNV event) {
        this.nhanVien = nhanVien;
        this.event = event;
    }

    public ModelEventNV() {
    }
    
    
}
