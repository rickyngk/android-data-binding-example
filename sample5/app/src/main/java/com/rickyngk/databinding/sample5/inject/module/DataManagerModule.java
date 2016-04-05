package com.rickyngk.databinding.sample5.inject.module;

import com.rickyngk.databinding.sample5.data.IContactService;
import com.rickyngk.databinding.sample5.data.MockContactService;
import com.rickyngk.databinding.sample5.inject.scope.PerDataManager;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by duynk on 4/5/16.

 */
@Module
public class DataManagerModule {
    @Provides
    @PerDataManager
    IContactService provideContactDataService() {
        return new MockContactService();
    }

    @Provides
    @PerDataManager
    Scheduler provideSubscribeScheduler() {
        return Schedulers.io();
    }
}
