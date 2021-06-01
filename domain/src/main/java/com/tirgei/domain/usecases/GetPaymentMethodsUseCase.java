package com.tirgei.domain.usecases;

import com.tirgei.domain.models.PaymentMethod;
import com.tirgei.domain.repositories.IPaymentsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

/**
 * Use case to fetch available payment methods
 */
public class GetPaymentMethodsUseCase implements BaseUseCase<Single<List<PaymentMethod>>> {

    private final IPaymentsRepository repository;

    @Inject
    public GetPaymentMethodsUseCase(IPaymentsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Single<List<PaymentMethod>> invoke() {
        return repository.fetchPaymentMethods();
    }
}
