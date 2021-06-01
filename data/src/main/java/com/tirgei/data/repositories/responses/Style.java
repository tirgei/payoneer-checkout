package com.tirgei.data.repositories.responses;

import com.google.gson.annotations.SerializedName;

public class Style {

    @SerializedName("language")
    private String language;

    public Style(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Style{" +
                "language='" + language + '\'' +
                '}';
    }
}
