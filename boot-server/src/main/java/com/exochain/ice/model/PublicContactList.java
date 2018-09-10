package com.exochain.ice.model;

import com.exochain.ice.model.IContactList;
import com.exochain.ice.model.Contact;

public class PublicContactList extends IContactList {
    public Contact you = new Contact();
    public Contact primary = new Contact();
    public Contact alternative = new Contact();
    public Contact contingency = new Contact();
    public Contact emergency = new Contact();
    public void initialize() {
        you.initialize(true);
        primary.initialize();
        alternative.initialize();
        contingency.initialize();
        emergency.initialize();
    }
}

