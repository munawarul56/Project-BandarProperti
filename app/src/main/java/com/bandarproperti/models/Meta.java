package com.bandarproperti.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Links {

    @SerializedName("previous")
    @Expose
    public String previous;
    @SerializedName("next")
    @Expose
    public String next;

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}

public class Meta {

    @SerializedName("pagination")
    @Expose
    public Pagination pagination;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
