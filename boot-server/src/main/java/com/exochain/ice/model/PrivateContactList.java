package com.exochain.ice.model;

import com.exochain.ice.model.Contact;
import com.exochain.ice.model.IContactList;
import com.exochain.ice.model.PublicContactList;

public class PrivateContactList extends IContactList {
    public Contact physician = new Contact();
    public Contact attorney = new Contact();
    public Contact cpa = new Contact();
    public Contact estate = new Contact();
    public PublicContactList escrow = new PublicContactList(); // Public contacts
}

