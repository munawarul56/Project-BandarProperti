package com.bandarproperti.models;

public class Gallery {
    public int id;
    public int property_id;
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
