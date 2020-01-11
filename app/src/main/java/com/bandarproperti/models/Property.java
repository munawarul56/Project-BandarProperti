package com.bandarproperti.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

class City {

    @SerializedName("village")
    @Expose
    public String village;
    @SerializedName("district")
    @Expose
    public String district;
    @SerializedName("regency")
    @Expose
    public String regency;
    @SerializedName("province")
    @Expose
    public String provinnce;
}

public class Property{

    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("desc")
    @Expose
    public String desc;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("city")
    @Expose
    public City city;
    @SerializedName("price")
    @Expose
    public int price;
    @SerializedName("price_postfix")
    @Expose
    public String price_postfix;
    @SerializedName("area_size")
    @Expose
    public String area_size;
    @SerializedName("size_postfix")
    @Expose
    public String size_postfix;
    @SerializedName("bedrooms")
    @Expose
    public int bedrooms;
    @SerializedName("bathrooms")
    @Expose
    public int bathrooms;
    @SerializedName("gerages")
    @Expose
    public int gerages;
    @SerializedName("year_build")
    @Expose
    public String year_build;
    @SerializedName("address")
    @Expose
    public String address;
    @SerializedName("lat")
    @Expose
    public String lat;
    @SerializedName("lnt")
    @Expose
    public String lng;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("created_at")
    @Expose
    public String created_at;
    @SerializedName("features")
    @Expose
    public List<Feature> features;
    @SerializedName("galleries")
    @Expose
    public List<Gallery> galleries;

    public Property() {
    }

    public Property(int id, String name, String desc, String status, String type, City city, int price, String price_postfix, String area_size, String size_postfix, int bedrooms, int bathrooms, int gerages, String year_build, String address, String lat, String lng, String image, String created_at, List<Feature> features, List<Gallery> galleries) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.status = status;
        this.type = type;
        this.city = city;
        this.price = price;
        this.price_postfix = price_postfix;
        this.area_size = area_size;
        this.size_postfix = size_postfix;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.gerages = gerages;
        this.year_build = year_build;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
        this.image = image;
        this.created_at = created_at;
        this.features = features;
        this.galleries = galleries;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPrice_postfix() {
        return price_postfix;
    }

    public void setPrice_postfix(String price_postfix) {
        this.price_postfix = price_postfix;
    }

    public String getArea_size() {
        return area_size;
    }

    public void setArea_size(String area_size) {
        this.area_size = area_size;
    }

    public String getSize_postfix() {
        return size_postfix;
    }

    public void setSize_postfix(String size_postfix) {
        this.size_postfix = size_postfix;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getGerages() {
        return gerages;
    }

    public void setGerages(int gerages) {
        this.gerages = gerages;
    }

    public String getYear_build() {
        return year_build;
    }

    public void setYear_build(String year_build) {
        this.year_build = year_build;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<Gallery> getGalleries() {
        return galleries;
    }

    public void setGalleries(List<Gallery> galleries) {
        this.galleries = galleries;
    }
}
