package com.bandarproperti.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PropertyFavorite {

    @SerializedName("id")
    @Expose
    Integer id;
    @SerializedName("customer_id")
    @Expose
    Integer customer_id;
    @SerializedName("property_id")
    @Expose
    Integer property_id;

    public PropertyFavorite() {
    }

    public PropertyFavorite(Integer id, Integer customer_id, Integer property_id) {
        this.id = id;
        this.customer_id = customer_id;
        this.property_id = property_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getProperty_id() {
        return property_id;
    }

    public void setProperty_id(Integer property_id) {
        this.property_id = property_id;
    }
}
