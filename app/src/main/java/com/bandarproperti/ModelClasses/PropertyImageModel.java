package com.bandarproperti.ModelClasses;


public class PropertyImageModel {
    Integer image;
    String imageNo;

    public PropertyImageModel(Integer image, String imageNo) {
        this.image = image;
        this.imageNo = imageNo;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getImageNo() {
        return imageNo;
    }

    public void setImageNo(String imageNo) {
        this.imageNo = imageNo;
    }
}
