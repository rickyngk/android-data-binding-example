package com.rickyngk.databinding.sample5.data;

import android.content.Context;

import com.rickyngk.databinding.sample5.MyApp;
import com.rickyngk.databinding.sample5.inject.component.DaggerDataManagerComponent;
import com.rickyngk.databinding.sample5.inject.module.DataManagerModule;

import javax.inject.Inject;

import rx.Scheduler;

/**
 * Created by duynk on 4/5/16.
 */
public class DataManager {
    @Inject
    protected IContactService contactService;
    @Inject
    protected Scheduler subscribeScheduler;

    public DataManager(Context context) {
        injectDependency(context);
    }

    public DataManager(IContactService contactService, Scheduler scheduler) {
        this.contactService = contactService;
        this.subscribeScheduler = scheduler;
    }

    public void injectDependency(Context context) {
        DaggerDataManagerComponent.builder()
                .appComponent(MyApp.get(context).getAppComponent())
                .dataManagerModule(new DataManagerModule())
                .build()
                .inject(this);
    }

    public Scheduler getSubscribeScheduler() {
        return subscribeScheduler;
    }
    public rx.Observable<ContactResult> getContacts() {
        return contactService.getContacts();
    }
}
