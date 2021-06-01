package com.tirgei.domain.models;

/**
 * Data class for available payment method. Available fields are:
 * code - short code of payment method
 * label - full name of payment method
 * logo - logo of payment method
 */
public class PaymentMethod {
    private final String code;
    private final String label;
    private final String logo;

    public PaymentMethod(String code, String label, String logo) {
        this.code = code;
        this.label = label;
        this.logo = logo;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public String getLogo() {
        return logo;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "code='" + code + '\'' +
                ", label='" + label + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
