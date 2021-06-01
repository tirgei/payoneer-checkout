package com.tirgei.payoneercheckout.ui.interfaces;

import com.tirgei.domain.models.PaymentMethod;

public interface PaymentCallback {
    void onPaymentMethodClicked(PaymentMethod method);
}
