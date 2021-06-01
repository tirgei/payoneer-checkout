package com.tirgei.data.repositories;

import com.tirgei.data.mappers.ResponseToDomainMapper;
import com.tirgei.data.remote.ApiService;
import com.tirgei.data.repositories.responses.Applicable;
import com.tirgei.domain.models.PaymentMethod;
import com.tirgei.domain.repositories.IPaymentsRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Repository class to handle data requests to respective data source in this case
 * from API Server only
 */
public class PaymentsRepository implements IPaymentsRepository {

    private final ApiService apiService;

    @Inject
    public PaymentsRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Single<List<PaymentMethod>> fetchPaymentMethods() {
        return apiService.fetchPaymentMethods()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(paymentsResponse -> {
                    List<PaymentMethod> paymentMethods = new ArrayList<>();

                    for (Applicable applicable : paymentsResponse.getNetworks().getApplicable()) {
                        paymentMethods.add(ResponseToDomainMapper.applicableToDomain(applicable));
                    }
                    return paymentMethods;
                });
    }
}
