package com.tirgei.domain.usecases;

import com.tirgei.domain.models.PaymentMethod;
import com.tirgei.domain.repositories.IPaymentsRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.observers.TestObserver;

public class GetPaymentMethodsUseCaseTest {

    private final IPaymentsRepository paymentsRepository = Mockito.mock(IPaymentsRepository.class);

    private final TestObserver<List<PaymentMethod>> testObserver = new TestObserver<>();
    private GetPaymentMethodsUseCase paymentMethodsUseCase;

    @Before
    public void setup() {
        paymentMethodsUseCase = new GetPaymentMethodsUseCase(paymentsRepository);
    }

    @After
    public void tearDown() {
        testObserver.dispose();
    }

    @Test
    public void fetchEmptyList_returnsEmptyList() {
        Mockito.when(paymentsRepository.fetchPaymentMethods()).thenReturn(Single.just(new ArrayList<>()));

        paymentMethodsUseCase
                .invoke()
                .subscribe(testObserver);

        Mockito.verify(paymentsRepository, Mockito.times(1)).fetchPaymentMethods();
        testObserver.assertNoErrors();
        testObserver.assertValue(new ArrayList<>());
    }

    @Test
    public void fetchListWithItems_returnsListWithSingleItem() {
        PaymentMethod paymentMethod = new PaymentMethod("AMEX", "American Express", "logo");
        List<PaymentMethod> paymentMethods = Collections.singletonList(paymentMethod);

        Mockito.when(paymentsRepository.fetchPaymentMethods())
                .thenReturn(Single.just(paymentMethods));

        paymentMethodsUseCase.invoke()
                .subscribe(testObserver);

        Mockito.verify(paymentsRepository, Mockito.times(1)).fetchPaymentMethods();
        testObserver.assertNoErrors();
        testObserver.assertValue(paymentMethods);
    }

}