package com.rickyngk.databinding.sample5.inject.module;

import com.rickyngk.databinding.sample5.data.RestApiService;
import com.rickyngk.databinding.sample5.data.RetrofitHelper;
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
    RestApiService provideRestApiService() {
        return new RetrofitHelper().newRestApiService();
    }

    @Provides
    @PerDataManager
    Scheduler provideSubscribeScheduler() {
        return Schedulers.io();
    }
}
