package com.tirgei.domain.repositories;

import com.tirgei.domain.models.PaymentMethod;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Interface representing available methods for payments module
 */
public interface IPaymentsRepository {

    Single<List<PaymentMethod>> fetchPaymentMethods();

}
