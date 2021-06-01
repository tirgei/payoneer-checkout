package com.tirgei.data.repositories.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Response class for applicable {@link com.tirgei.domain.models.PaymentMethod}
 */
public class Applicable {

    @SerializedName("code")
    private String code;

    @SerializedName("label")
    private String label;

    @SerializedName("method")
    private String method;

    @SerializedName("grouping")
    private String grouping;

    @SerializedName("registration")
    private String registration;

    @SerializedName("recurrence")
    private String recurrence;

    @SerializedName("redirect")
    private Boolean redirect;

    @SerializedName("operationType")
    private String operationType;

    @SerializedName("links")
    private Links links;

    @SerializedName("inputElements")
    private List<InputElements> inputElements;

    public Applicable(String code, String label, String method, String grouping, String registration, String recurrence, Boolean redirect, String operationType, Links links, List<InputElements> inputElements) {
        this.code = code;
        this.label = label;
        this.method = method;
        this.grouping = grouping;
        this.registration = registration;
        this.recurrence = recurrence;
        this.redirect = redirect;
        this.operationType = operationType;
        this.links = links;
        this.inputElements = inputElements;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public Links getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "Applicable{" +
                "code='" + code + '\'' +
                ", label='" + label + '\'' +
                ", method='" + method + '\'' +
                ", grouping='" + grouping + '\'' +
                ", registration='" + registration + '\'' +
                ", recurrence='" + recurrence + '\'' +
                ", redirect=" + redirect +
                ", operationType='" + operationType + '\'' +
                ", links=" + links +
                ", inputElements=" + inputElements +
                '}';
    }
}
