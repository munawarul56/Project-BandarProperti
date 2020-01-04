package com.bandarproperti.response;

import com.bandarproperti.models.Meta;
import com.bandarproperti.models.Property;

import java.util.List;

public class PropertyApiResponse {
    public List<Property> property;
    public Meta meta;

    public List<Property> getProperty() {
        return property;
    }

    public void setProperty(List<Property> property) {
        this.property = property;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
