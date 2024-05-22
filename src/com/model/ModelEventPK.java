package com.model;

import com.event.EventPK;
import com.model.ModelPhuKien;

public class ModelEventPK {
    
    private ModelPhuKien model;
    private EventPK event;

    public ModelPhuKien getModel() {
        return model;
    }

    public void setModel(ModelPhuKien model) {
        this.model = model;
    }

    public EventPK getEvent() {
        return event;
    }

    public void setEvent(EventPK event) {
        this.event = event;
    }

    public ModelEventPK(ModelPhuKien model, EventPK event) {
        this.model = model;
        this.event = event;
    }

    public ModelEventPK() {
    }
    
}
