package com.tirgei.data.repositories.responses;

import com.google.gson.annotations.SerializedName;

public class Payment {

    @SerializedName("reference")
    private String reference;

    @SerializedName("amount")
    private int amount;

    @SerializedName("currency")
    private String currency;

    public Payment(String reference, int amount, String currency) {
        this.reference = reference;
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "reference='" + reference + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
