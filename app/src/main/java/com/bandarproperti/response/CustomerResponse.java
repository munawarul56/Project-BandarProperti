package com.bandarproperti.response;

import com.bandarproperti.models.Customer;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerResponse {

    @SerializedName("customer")
    @Expose
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
