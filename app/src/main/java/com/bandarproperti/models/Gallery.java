package com.bandarproperti.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gallery {

    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("property_id")
    @Expose
    public int property_id;
    @SerializedName("image")
    @Expose
    public String image;

    public Gallery() {
    }

    public Gallery(int id, int property_id, String image) {
        this.id = id;
        this.property_id = property_id;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
