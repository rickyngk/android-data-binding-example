package com.rickyngk.databinding.sample5.data;

import com.rickyngk.databinding.sample5.model.Question;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by duynk on 4/5/16.
 *
 */
public interface RestApiService {
    public final static String ENDPOINT = "https://private-dcef9-daggertest.apiary-mock.com/";

    @GET("questions")
    Observable<RestApiListResult<Question>> getQuestions();
}
