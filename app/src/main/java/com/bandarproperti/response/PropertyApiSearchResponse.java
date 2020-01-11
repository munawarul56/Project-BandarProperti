package com.bandarproperti.response;

import com.bandarproperti.models.Meta;
import com.bandarproperti.models.Property;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PropertyApiSearchResponse {

    @SerializedName("property")
    @Expose
    public List<Property> property;

    public List<Property> getProperty() {
        return property;
    }

    public void setProperty(List<Property> property) {
        this.property = property;
    }
}
