package com.rickyngk.databinding.sample2;

import android.content.Context;
import android.view.View;

/**
 * Created by duynk on 4/4/16.
 *
 */
public class SampleViewModel {
    private String buttonTitle = "Click me!";
    private Context context;

    public static interface ISampleViewModelEventListener {
        void onClickButton();
    }
    private ISampleViewModelEventListener listener;

    public SampleViewModel(Context context, ISampleViewModelEventListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public String getButtonTitle() {
        return buttonTitle;
    }

    public void onClick(View v) {
        //do something with model or view-model state
        System.out.println("Do something with model or view-model state");
        //then invoke event
        listener.onClickButton();
    }
}
