package com.example.carwashing.ui;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;

/**
 * Data Binding adapters specific to the app.
 */
public class BindingAdapters {

    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter({"message", "resId"})
    public static void setFormattedText(TextView textView, String message, int resId){
        if(resId != 0){
            textView.setText(textView.getResources().getString(resId));
        }else{
            textView.setText(message);
        }
    }
}
