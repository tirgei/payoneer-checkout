package com.tirgei.payoneercheckout.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.tirgei.domain.models.PaymentMethod;
import com.tirgei.payoneercheckout.R;
import com.tirgei.payoneercheckout.databinding.ItemPaymentMethodBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView adapter for {@link PaymentMethod}s
 */
public class PaymentsAdapter extends RecyclerView.Adapter<PaymentsAdapter.PaymentHolder> {
    private final List<PaymentMethod> paymentMethods = new ArrayList<>();

    /**
     * Set list of {@link PaymentMethod}s
     * @param paymentMethods - list of payment methods
     */
    public void setData(List<PaymentMethod> paymentMethods) {
        this.paymentMethods.clear();
        this.paymentMethods.addAll(paymentMethods);
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public PaymentHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new PaymentHolder(
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_payment_method, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PaymentsAdapter.PaymentHolder holder, int position) {
        holder.bind(paymentMethods.get(position));
    }

    @Override
    public int getItemCount() {
        return paymentMethods.size();
    }

    static class PaymentHolder extends RecyclerView.ViewHolder {

        private final ItemPaymentMethodBinding binding;

        public PaymentHolder(ItemPaymentMethodBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(PaymentMethod paymentMethod) {
            binding.setPaymentMethod(paymentMethod);
        }
    }

}
