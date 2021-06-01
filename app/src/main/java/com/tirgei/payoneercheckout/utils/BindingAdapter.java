package com.tirgei.payoneercheckout.utils;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class BindingAdapter {

    @androidx.databinding.BindingAdapter("visible")
    public static void setVisibility(View view, Boolean isVisible) {
        if (isVisible) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

    @androidx.databinding.BindingAdapter("image")
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .thumbnail(0.3f)
                .into(imageView);
    }

}
