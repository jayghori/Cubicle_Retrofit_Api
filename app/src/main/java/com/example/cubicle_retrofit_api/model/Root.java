package com.example.cubicle_retrofit_api.model;

import java.util.List;

public class Root {

    public List<Contacts> contacts;

    public Root(List<Contacts> contacts) {
        this.contacts = contacts;
    }

    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }
}
