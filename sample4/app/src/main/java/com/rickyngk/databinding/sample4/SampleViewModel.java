package com.rickyngk.databinding.sample4;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

/**
 * Created by duynk on 4/4/16.
 */
public class SampleViewModel extends BaseObservable {
    SampleModel model = new SampleModel();
    private ISampleViewModelEventListener listener;
    private Context context;
    private String sendTo = "";
    private String message = "";

    public SampleViewModel(Context ctx, ISampleViewModelEventListener listener) {
        this.context = ctx;
        this.listener = listener;
    }


    @Bindable
    public String getCharCount() {
        return "Count: " + message.length();
    }

    @Bindable
    public boolean isValidEmail() {
        return sendTo != null && android.util.Patterns.EMAIL_ADDRESS.matcher(sendTo).matches();
    }

    @Bindable
    public boolean isInvalidEmail() {
        return sendTo != null && sendTo.length() > 0 && !android.util.Patterns.EMAIL_ADDRESS.matcher(sendTo).matches();
    }

    public void onSave(View v) {
        listener.onBeforeSavingData();

        model.setMessage(message);
        model.setSendTo(sendTo);
        model.save(new SampleModel.IComposeCallback() {
            @Override
            public void onDone(SampleModel.ComposeError error) {
                if (error != null) {
                    listener.onSaveError(error.code, error.message);
                } else {
                    listener.onSaveSuccess();
                }
            }
        });
    }

    public TextWatcher receiverWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            sendTo = s.toString();
            notifyPropertyChanged(com.rickyngk.databinding.sample4.BR.validEmail);
            notifyPropertyChanged(com.rickyngk.databinding.sample4.BR.invalidEmail);
        }
    };

    public TextWatcher messageWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            message = s.toString();
            notifyPropertyChanged(com.rickyngk.databinding.sample4.BR.charCount);
        }
    };

    public interface ISampleViewModelEventListener {
        void onBeforeSavingData();
        void onSaveError(int code, String message);
        void onSaveSuccess();
    }
}
