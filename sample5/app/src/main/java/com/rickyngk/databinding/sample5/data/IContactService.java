package com.rickyngk.databinding.sample5.data;

import com.rickyngk.databinding.sample5.model.Contact;

/**
 * Created by duynk on 4/5/16.
 */
public interface IContactService {
    rx.Observable<Contact> getContacts();
}
