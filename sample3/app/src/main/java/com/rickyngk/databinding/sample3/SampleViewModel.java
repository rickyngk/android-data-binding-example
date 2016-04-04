package com.rickyngk.databinding.sample3;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

/**
 * Created by duynk on 4/4/16.
 *
 */
public class SampleViewModel extends BaseObservable {
    private String text = "";
    private String prefix = "Clicked";
    private int clickCounter = 0;

    public SampleViewModel() {
        setText(prefix + " : " + clickCounter);
    }

    @Bindable
    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(com.rickyngk.databinding.sample3.BR.text);
    }

    public void onClick(View v) {
        clickCounter++;
        setText(prefix + " : " + clickCounter);
    }

    private String prefix = "Clicked";

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;

        //update text
        setText(prefix + " : " + clickCounter);
        notifyPropertyChanged(com.rickyngk.databinding.sample3.BR.text);
    }

    public TextWatcher prefixWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            setPrefix(s.toString());
        }
    };
}
