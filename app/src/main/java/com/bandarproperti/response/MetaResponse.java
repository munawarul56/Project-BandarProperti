package com.bandarproperti.response;

import com.bandarproperti.models.Meta;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MetaResponse {

    @SerializedName("meta")
    @Expose
    public Meta meta;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
