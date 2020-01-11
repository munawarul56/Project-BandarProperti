package com.bandarproperti.response;

import com.bandarproperti.models.Status;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StatusResponse {

    @SerializedName("status")
    @Expose
    public List<Status> status;

    public List<Status> getStatus() {
        return status;
    }

    public void setStatus(List<Status> status) {
        this.status = status;
    }
}
