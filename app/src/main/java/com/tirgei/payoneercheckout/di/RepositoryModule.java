package com.tirgei.payoneercheckout.di;

import com.tirgei.data.remote.ApiService;
import com.tirgei.data.repositories.PaymentsRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {

    @Provides
    @Singleton
    public static PaymentsRepository providesPaymentsRepository(
            ApiService apiService
    ) {
        return new PaymentsRepository(apiService);
    }

}
