package com.tirgei.data.repositories.responses;

import com.google.gson.annotations.SerializedName;

/**
 * Response class for data from {@link com.tirgei.data.remote.ApiService}
 */
public class PaymentsResponse {

    @SerializedName("links")
    private Links links;

    @SerializedName("timestamp")
    private String string;

    @SerializedName("operation")
    private String operation;

    @SerializedName("resultCode")
    private String resultCode;

    @SerializedName("resultInfo")
    private String resultInfo;

    @SerializedName("returnCode")
    private ReturnCode returnCode;

    @SerializedName("status")
    private Status status;

    @SerializedName("interaction")
    private Interaction interaction;

    @SerializedName("networks")
    private Networks networks;

    @SerializedName("operationType")
    private String operationType;

    @SerializedName("style")
    private Style style;

    @SerializedName("payment")
    private Payment payment;

    @SerializedName("integrationType")
    private String integrationType;

    public PaymentsResponse(Links links, String string, String operation, String resultCode, String resultInfo, ReturnCode returnCode, Status status, Interaction interaction, Networks networks, String operationType, Style style, Payment payment, String integrationType) {
        this.links = links;
        this.string = string;
        this.operation = operation;
        this.resultCode = resultCode;
        this.resultInfo = resultInfo;
        this.returnCode = returnCode;
        this.status = status;
        this.interaction = interaction;
        this.networks = networks;
        this.operationType = operationType;
        this.style = style;
        this.payment = payment;
        this.integrationType = integrationType;
    }

    public Networks getNetworks() {
        return networks;
    }

    @Override
    public String toString() {
        return "PaymentsResponse{" +
                "links=" + links +
                ", string='" + string + '\'' +
                ", operation='" + operation + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", resultInfo='" + resultInfo + '\'' +
                ", returnCode=" + returnCode +
                ", status=" + status +
                ", interaction=" + interaction +
                ", networks=" + networks +
                ", operationType='" + operationType + '\'' +
                ", style=" + style +
                ", payment=" + payment +
                ", integrationType='" + integrationType + '\'' +
                '}';
    }
}
