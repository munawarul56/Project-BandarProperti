package com.bandarproperti.models;

import java.util.List;

class City {
    public String village;
    public String district;
    public String regency;
    public String provinnce;
}

class Feature {
    public int id;
    public int property_id;
    public int feature_id;
    public String name;
    public String icon;
}

class Gallery {
    public int id;
    public int property_id;
    public String image;
}

public class Property {
    public int id;
    public String name;
    public String desc;
    public String status;
    public String type;
    public City city;
    public int price;
    public String price_postfix;
    public int area_size;
    public String size_postfix;
    public int bedrooms;
    public int bathrooms;
    public int gerages;
    public String year_build;
    public String address;
    public String lat;
    public String lng;
    public String image;
    public String created_at;
    public List<Feature> features;
    public List<Gallery> galleries;
}
