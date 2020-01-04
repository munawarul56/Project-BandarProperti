package com.bandarproperti.models;

public class Feature {
    public int id;
    public int property_id;
    public int feature_id;
    public String name;
    public String icon;

    public Feature() {
    }

    public Feature(int id, int property_id, int feature_id, String name, String icon) {
        this.id = id;
        this.property_id = property_id;
        this.feature_id = feature_id;
        this.name = name;
        this.icon = icon;
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

    public int getFeature_id() {
        return feature_id;
    }

    public void setFeature_id(int feature_id) {
        this.feature_id = feature_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
