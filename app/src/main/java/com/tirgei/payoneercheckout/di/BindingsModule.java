package com.tirgei.payoneercheckout.di;

import com.tirgei.data.repositories.PaymentsRepository;
import com.tirgei.domain.repositories.IPaymentsRepository;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class BindingsModule {

    @Binds
    public abstract IPaymentsRepository bindPaymentsRepository(
            PaymentsRepository paymentsRepository
    );

}
