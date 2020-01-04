package com.bandarproperti.response;

import com.bandarproperti.models.Meta;
import com.bandarproperti.models.Property;

import java.util.List;

public class PropertyApiSearchResponse {
    public List<Property> property;

    public List<Property> getProperty() {
        return property;
    }

    public void setProperty(List<Property> property) {
        this.property = property;
    }
}
