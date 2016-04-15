package com.rickyngk.databinding.sample5.data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by duynk on 4/5/16.
 *
 */
public class RetrofitHelper {
    public RestApiService newRestApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(RestApiService.class);
    }
}