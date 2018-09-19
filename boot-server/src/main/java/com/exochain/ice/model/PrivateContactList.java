package com.exochain.ice;

import com.exochain.ice.Contact;
import com.exochain.ice.IContactList;
import com.exochain.ice.PublicContactList;

public class PrivateContactList extends IContactList {
    public Contact physician = new Contact();
    public Contact attorney = new Contact();
    public Contact cpa = new Contact();
    public Contact estate = new Contact();
    public PublicContactList escrow = new PublicContactList(); // Public contacts
}

