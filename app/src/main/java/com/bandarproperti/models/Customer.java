package com.bandarproperti.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer {

    @SerializedName("id")
    @Expose
    Integer id;
    @SerializedName("email")
    @Expose
    String email;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("password")
    @Expose
    String password;
    @SerializedName("phone")
    @Expose
    String phone;
    @SerializedName("gender")
    @Expose
    String gender;
    @SerializedName("picture")
    @Expose
    String picture;
    @SerializedName("address")
    @Expose
    String address;
    @SerializedName("created_at")
    @Expose
    String created_at;

    public Customer() {
    }

    public Customer(Integer id, String email, String name, String password, String phone, String gender, String picture, String address, String created_at) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.gender = gender;
        this.picture = picture;
        this.address = address;
        this.created_at = created_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
