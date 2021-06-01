package com.tirgei.payoneercheckout.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;

/**
 * This class observes network connection
 */
public class NetworkManager {

    private final ConnectivityManager connectivityManager;

    public NetworkManager(Context context) {
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    /**
     * Create a LiveData for internet changes
     * @return - LiveData with connectivity status
     */
    public LiveData<Boolean> internetObserver() {
        NetworkRequest request = new NetworkRequest.Builder()
                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .build();

        MutableLiveData<Boolean> _hasInternetLiveData = new MutableLiveData<>();

        connectivityManager.registerNetworkCallback(request, new ConnectivityManager.NetworkCallback(){
            @Override
            public void onAvailable(@NonNull Network network) {
                super.onAvailable(network);
                _hasInternetLiveData.postValue(true);
            }

            @Override
            public void onLost(@NonNull Network network) {
                super.onLost(network);
                _hasInternetLiveData.postValue(false);
            }
        });

        return _hasInternetLiveData;
    }
}
