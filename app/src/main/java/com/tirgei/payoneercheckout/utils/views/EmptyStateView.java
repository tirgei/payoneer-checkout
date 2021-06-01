package com.tirgei.payoneercheckout.utils.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.tirgei.payoneercheckout.R;

import org.jetbrains.annotations.NotNull;

public class EmptyStateView extends ConstraintLayout {

    private LottieAnimationView lottieAnimationView;
    private TextView messageView;

    public EmptyStateView(@NonNull @NotNull Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.layout_empty_state, this);

        messageView = findViewById(R.id.message);
        lottieAnimationView = findViewById(R.id.lottie);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EmptyStateView, 0, 0);
        try {
            String message = typedArray.getString(R.styleable.EmptyStateView_message);
            int animation = typedArray.getResourceId(R.styleable.EmptyStateView_animation, 0);

            setMessage(message);
            if (animation != 0) setAnimation(animation);

        } finally {
            typedArray.recycle();
        }
    }

    public void setEmptyState(String message, int animation) {
        messageView.setText(message);
        lottieAnimationView.setAnimation(animation);
    }

    public void setMessage(String message) {
        messageView.setText(message);
    }

    public void setAnimation(int resource) {
        lottieAnimationView.setAnimation(resource);
    }
}
