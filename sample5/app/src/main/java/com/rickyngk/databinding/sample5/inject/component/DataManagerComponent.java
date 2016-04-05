package com.rickyngk.databinding.sample5.inject.component;

import com.rickyngk.databinding.sample5.data.DataManager;
import com.rickyngk.databinding.sample5.inject.module.DataManagerModule;
import com.rickyngk.databinding.sample5.inject.scope.PerDataManager;

import dagger.Component;

/**
 * Created by duynk on 4/5/16.
 */
@PerDataManager
@Component(dependencies = AppComponent.class, modules = DataManagerModule.class)
public interface DataManagerComponent {
    void inject(DataManager dataManager);
}
