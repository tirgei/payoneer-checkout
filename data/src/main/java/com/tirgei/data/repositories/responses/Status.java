package com.tirgei.data.repositories.responses;

import com.google.gson.annotations.SerializedName;

public class Status {

    @SerializedName("code")
    private String code;

    @SerializedName("reason")
    private String reason;

    public Status(String code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Status{" +
                "code='" + code + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
