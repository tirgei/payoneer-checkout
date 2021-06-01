package com.tirgei.data.repositories.responses;

import com.google.gson.annotations.SerializedName;

public class Identification {
    @SerializedName("longId")
    private String longId;

    @SerializedName("shortId")
    private String shortId;

    @SerializedName("transactionId")
    private String transactionId;

    public Identification(String longId, String shortId, String transactionId) {
        this.longId = longId;
        this.shortId = shortId;
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Identification{" +
                "longId='" + longId + '\'' +
                ", shortId='" + shortId + '\'' +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }
}
