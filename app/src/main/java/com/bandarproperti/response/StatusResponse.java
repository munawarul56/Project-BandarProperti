package com.bandarproperti.response;

import com.bandarproperti.models.Status;

import java.util.List;

public class StatusResponse {
    public List<Status> status;

    public List<Status> getStatus() {
        return status;
    }

    public void setStatus(List<Status> status) {
        this.status = status;
    }
}
