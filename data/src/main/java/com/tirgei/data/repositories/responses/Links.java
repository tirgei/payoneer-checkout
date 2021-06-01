package com.tirgei.data.repositories.responses;

import com.google.gson.annotations.SerializedName;

/**
 * Response class for {@link com.tirgei.domain.models.PaymentMethod} links
 */
public class Links {

    @SerializedName("logo")
    private String logo;

    @SerializedName("self")
    private String self;

    @SerializedName("lang")
    private String lang;

    @SerializedName("operation")
    private String operation;

    @SerializedName("validation")
    private String validation;

    public Links(String logo, String self, String lang, String operation, String validation) {
        this.logo = logo;
        this.self = self;
        this.lang = lang;
        this.operation = operation;
        this.validation = validation;
    }

    public String getLogo() {
        return logo;
    }

    @Override
    public String toString() {
        return "Links{" +
                "logo='" + logo + '\'' +
                ", self='" + self + '\'' +
                ", lang='" + lang + '\'' +
                ", operation='" + operation + '\'' +
                ", validation='" + validation + '\'' +
                '}';
    }
}
