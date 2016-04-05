package com.rickyngk.databinding.sample5.inject.component;

import android.app.Application;

import com.rickyngk.databinding.sample5.MainActivity;
import com.rickyngk.databinding.sample5.data.DataManager;
import com.rickyngk.databinding.sample5.inject.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by duynk on 4/5/16.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MainActivity mainActivity);

    Application application();
    DataManager dataManager();
}
