package com.rickyngk.databinding.sample5.data;

import com.rickyngk.databinding.sample5.model.Contact;

/**
 * Created by duynk on 4/5/16.
 *
 */
public class MockContactService implements IContactService {

    @Override
    public rx.Observable<Contact> getContacts() {
        return rx.Observable.just(
                new Contact("user1", "user1@email.com"),
                new Contact("user2", "user2@email.com"),
                new Contact("user3", "user3@email.com"),
                new Contact("user4", "user4@email.com"),
                new Contact("user5", "user5@email.com")
        );
    }
}
