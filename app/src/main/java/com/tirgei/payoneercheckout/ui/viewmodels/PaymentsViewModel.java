package com.tirgei.payoneercheckout.ui.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tirgei.data.utils.NetworkResponse;
import com.tirgei.domain.models.PaymentMethod;
import com.tirgei.domain.usecases.GetPaymentMethodsUseCase;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * ViewModel class for Payments
 */
@HiltViewModel
public class PaymentsViewModel extends BaseViewModel {

    private final GetPaymentMethodsUseCase getPaymentMethodsUseCase;

    private MutableLiveData<NetworkResponse<List<PaymentMethod>>> _paymentsLiveData
            = new MutableLiveData<>();

    public LiveData<NetworkResponse<List<PaymentMethod>>> paymentsLiveData = _paymentsLiveData;

    @Inject
    public PaymentsViewModel(GetPaymentMethodsUseCase getPaymentMethodsUseCase) {
        this.getPaymentMethodsUseCase = getPaymentMethodsUseCase;
    }

    public void fetchPaymentMethods() {
        compositeDisposable.add(getPaymentMethodsUseCase.invoke()
        .doOnSubscribe(disposable -> {
            _paymentsLiveData.postValue(NetworkResponse.loading());
        })
        .subscribe(paymentMethods -> {
            _paymentsLiveData.postValue(NetworkResponse.success(paymentMethods));
        }, throwable -> {
            _paymentsLiveData.postValue(NetworkResponse.error(new Exception(throwable.getMessage())));
        }));

    }


}
