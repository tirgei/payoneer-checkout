package com.tirgei.data.remote;

import com.tirgei.data.repositories.responses.PaymentsResponse;
import com.tirgei.data.utils.Constants;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

/**
 * API Service to make requests to server
 */
public interface ApiService {

    @GET(Constants.PAYMENT_METHODS_URL)
    Single<PaymentsResponse> fetchPaymentMethods();

}
