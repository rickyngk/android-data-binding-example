package com.rickyngk.databinding.sample5.data;

import retrofit.http.GET;

/**
 * Created by duynk on 4/5/16.
 */
public interface IContactService {
    public final static String ENDPOINT = "https://private-dcef9-daggertest.apiary-mock.com";

    @GET("/questions")
    rx.Observable<ContactResult> getContacts();
}
