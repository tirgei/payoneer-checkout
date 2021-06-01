package com.tirgei.payoneercheckout.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tirgei.data.utils.NetworkResponse;
import com.tirgei.data.utils.NetworkStatus;
import com.tirgei.domain.models.PaymentMethod;
import com.tirgei.payoneercheckout.R;
import com.tirgei.payoneercheckout.databinding.FragmentPaymentMethodsBinding;
import com.tirgei.payoneercheckout.ui.adapters.PaymentsAdapter;
import com.tirgei.payoneercheckout.ui.viewmodels.PaymentsViewModel;
import com.tirgei.payoneercheckout.utils.NetworkManager;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

@AndroidEntryPoint
public class PaymentMethodsFragment extends Fragment {

    private FragmentPaymentMethodsBinding binding;
    private PaymentsViewModel paymentsViewModel;
    private PaymentsAdapter paymentsAdapter;
    private NetworkManager networkManager;

    public PaymentMethodsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_payment_methods, container, false);
        binding.setLifecycleOwner(this);

        paymentsViewModel = new ViewModelProvider(this).get(PaymentsViewModel.class);
        networkManager = new NetworkManager(requireContext());

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        paymentsAdapter = new PaymentsAdapter();
        binding.paymentsRv.setHasFixedSize(true);
        binding.paymentsRv.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.paymentsRv.setAdapter(paymentsAdapter);

        initPaymentsObserver();
        initNetworkObserver();
    }

    /**
     * Set lifecycle aware observer for payment methods
     */
    private void initPaymentsObserver() {
        paymentsViewModel.paymentsLiveData.observe(getViewLifecycleOwner(), listNetworkResponse -> {
            NetworkStatus networkStatus = listNetworkResponse.getStatus();
            binding.setStatus(networkStatus);

            switch (networkStatus){
                case SUCCESS:
                    List<PaymentMethod> paymentMethods = listNetworkResponse.getData();
                    if (paymentMethods.isEmpty()) {
                        binding.setStatus(NetworkStatus.ERROR);
                        binding.emptyStateView.setMessage(getString(R.string.message_no_payment_methods));
                    } else {
                        paymentsAdapter.setData(paymentMethods);
                    }
                    break;

                case ERROR:
                    binding.emptyStateView.setMessage(getString(R.string.message_unable_to_load_payment_methods));
                    break;
            }

        });
    }

    /**
     * Observer for internet connectivy changes
     */
    private void initNetworkObserver() {
        networkManager.internetObserver().observe(getViewLifecycleOwner(), hasInternet -> {
            if (hasInternet) {
                if (paymentsAdapter.getItemCount() == 0) {
                    paymentsViewModel.fetchPaymentMethods();
                }
            } else {
                if (paymentsAdapter.getItemCount() == 0) {
                    binding.emptyStateView.setMessage(getString(R.string.message_unable_to_load_payment_methods));
                    binding.setStatus(NetworkStatus.ERROR);
                } else {
                    Toast.makeText(requireContext(), getString(R.string.message_check_internet_connection), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}