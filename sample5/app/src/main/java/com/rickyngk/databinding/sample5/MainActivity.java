package com.rickyngk.databinding.sample5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rickyngk.databinding.sample5.data.ContactResult;
import com.rickyngk.databinding.sample5.data.DataManager;
import com.rickyngk.databinding.sample5.model.Contact;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {
    DataManager dataManager;
    ArrayList<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataManager = MyApp.get(this).getAppComponent().dataManager();


        dataManager.getContacts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(dataManager.getSubscribeScheduler())
                .subscribe(new Subscriber<ContactResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ContactResult contactResult) {
                        System.out.println(contactResult);
                    }
                });

    }
}
