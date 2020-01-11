package com.bandarproperti.response;

import com.bandarproperti.models.Property;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PropertyResponse {

    @SerializedName("property")
    @Expose
    public List<Property> properties;

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
