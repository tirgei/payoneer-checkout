package com.tirgei.payoneercheckout.utils;

import android.view.View;

public class BindingAdapter {

    @androidx.databinding.BindingAdapter("visible")
    public static void setVisibility(View view, Boolean isVisible) {
        if (isVisible) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

}
