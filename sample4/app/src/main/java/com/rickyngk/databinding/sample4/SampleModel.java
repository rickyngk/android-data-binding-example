package com.rickyngk.databinding.sample4;

/**
 * Created by duynk on 4/4/16.
 */
public class SampleModel {
    private String sendTo;
    private String message;

    public SampleModel(){}

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void save(final IComposeCallback callback) {
        if (sendTo == null || sendTo.length() == 0 || message == null || message.length() == 0 || !isValidEmail(sendTo)) {
            callback.onDone(new ComposeError(1, "invalidate"));
        } else {
            //simulate network saving
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        callback.onDone(null);
                    } catch (Exception E) {
                        E.printStackTrace();
                        callback.onDone(new ComposeError(2, "runtime error"));
                    }
                }
            }).start();
        }
    }

    public static class ComposeError {
        int code;
        String message;
        public ComposeError(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }

    public interface IComposeCallback {
        void onDone(ComposeError error);
    }

    public boolean isValidEmail(String email) {
        return email != null && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
