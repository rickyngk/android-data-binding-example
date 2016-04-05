package com.rickyngk.databinding.sample5.data;

import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by duynk on 4/5/16.
 *
 */
public class RetrofitHelper {
    public IContactService newContactService() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(IContactService.ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(new GsonBuilder().create()))
                .build();
        return restAdapter.create(IContactService.class);
    }
}
