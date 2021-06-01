package com.tirgei.data.repositories.responses;

import com.google.gson.annotations.SerializedName;

public class ReturnCode {

    @SerializedName("name")
    private String name;

    @SerializedName("source")
    private String source;

    public ReturnCode(String name, String source) {
        this.name = name;
        this.source = source;
    }

    @Override
    public String toString() {
        return "ReturnCode{" +
                "name='" + name + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
