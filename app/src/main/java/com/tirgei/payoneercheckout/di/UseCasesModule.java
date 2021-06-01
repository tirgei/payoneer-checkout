package com.tirgei.payoneercheckout.di;

import com.tirgei.data.repositories.PaymentsRepository;
import com.tirgei.domain.usecases.GetPaymentMethodsUseCase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;

@Module
@InstallIn(Singleton.class)
public class UseCasesModule {

    @Provides
    @Singleton
    public static GetPaymentMethodsUseCase provideGetPaymentMethodsUseCase(
            PaymentsRepository paymentsRepository
    ) {
        return new GetPaymentMethodsUseCase(paymentsRepository);
    }

}
