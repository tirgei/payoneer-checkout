package com.tirgei.data.repositories.responses;

import com.google.gson.annotations.SerializedName;

/**
 * Response class for Input Elements for {@link com.tirgei.domain.models.PaymentMethod}s
 */
public class InputElements {

    @SerializedName("name")
    private final String name;

    @SerializedName("type")
    private final String type;

    public InputElements(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "InputElements{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
