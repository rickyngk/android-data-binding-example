package com.rickyngk.databinding.sample5.data;

import android.content.Context;

import com.rickyngk.databinding.sample5.MyApp;
import com.rickyngk.databinding.sample5.inject.component.DaggerDataManagerComponent;
import com.rickyngk.databinding.sample5.inject.module.DataManagerModule;
import com.rickyngk.databinding.sample5.model.Question;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by duynk on 4/5/16.
 */
public class DataManager {
    @Inject
    protected RestApiService restApiService;
    @Inject
    protected Scheduler subscribeScheduler;

    public DataManager(Context context) {
        injectDependency(context);
    }

    public DataManager(RestApiService restApiService, Scheduler scheduler) {
        this.restApiService = restApiService;
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
    public Observable<RestApiListResult<Question>> getQuestions() {
        return restApiService.getQuestions();
    }
}
