package com.rickyngk.databinding.sample5;

import android.app.Application;
import android.content.Context;

import com.rickyngk.databinding.sample5.inject.component.AppComponent;
import com.rickyngk.databinding.sample5.inject.component.DaggerAppComponent;
import com.rickyngk.databinding.sample5.inject.module.AppModule;

/**
 * Created by duynk on 4/5/16.
 */
public class MyApp extends Application {
    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public static MyApp get(Context context) {
        return (MyApp) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public void setAppComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }
}
