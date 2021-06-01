package com.tirgei.data.repositories.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Response class for {@link com.tirgei.domain.models.PaymentMethod}s
 */
public class Networks {

    @SerializedName("applicable")
    private List<Applicable> applicable;

    public Networks(List<Applicable> applicable) {
        this.applicable = applicable;
    }

    public List<Applicable> getApplicable() {
        return applicable;
    }

    @Override
    public String toString() {
        return "Networks{" +
                "applicable=" + applicable +
                '}';
    }
}
