package com.tirgei.payoneercheckout.ui.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tirgei.payoneercheckout.R;
import com.tirgei.payoneercheckout.databinding.FragmentPaymentMethodsBinding;


public class PaymentMethodsFragment extends Fragment {

    private FragmentPaymentMethodsBinding binding;

    public PaymentMethodsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_payment_methods, container, false);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }
}