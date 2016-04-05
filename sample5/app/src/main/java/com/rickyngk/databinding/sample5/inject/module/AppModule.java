package com.rickyngk.databinding.sample5.inject.module;

import android.app.Application;

import com.rickyngk.databinding.sample5.data.DataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by duynk on 4/5/16.
 *
 */
@Module
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides @Singleton
    Application provideApplication() {
        return this.application;
    }

    @Provides @Singleton
    DataManager provideDataManager() {
        return new DataManager(this.application);
    }
}
