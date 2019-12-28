package com.bandarproperti.models;


public class PropertyRecyclerModel {

    String propertyName,type,street2,amount,bedCount,carParking,swimmingpool;

    public PropertyRecyclerModel(String propertyName, String type, String street2, String amount, String bedCount, String carParking, String swimmingpool) {
        this.propertyName = propertyName;
        this.type = type;
        this.street2 = street2;
        this.amount = amount;
        this.bedCount = bedCount;
        this.carParking = carParking;
        this.swimmingpool = swimmingpool;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getType() {
        return type;
    }

    public void setType(String street1) {
        this.type = type;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBedCount() {
        return bedCount;
    }

    public void setBedCount(String bedCount) {
        this.bedCount = bedCount;
    }

    public String getCarParking() {
        return carParking;
    }

    public void setCarParking(String carParking) {
        this.carParking = carParking;
    }

    public String getSwimmingpool() {
        return swimmingpool;
    }

    public void setSwimmingpool(String swimmingpool) {
        this.swimmingpool = swimmingpool;
    }
}
