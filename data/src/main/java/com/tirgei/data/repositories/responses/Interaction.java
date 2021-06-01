package com.tirgei.data.repositories.responses;

import com.google.gson.annotations.SerializedName;

public class Interaction {

    @SerializedName("code")
    private String code;

    @SerializedName("reason")
    private String reason;

    public Interaction(String code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Interaction{" +
                "code='" + code + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
