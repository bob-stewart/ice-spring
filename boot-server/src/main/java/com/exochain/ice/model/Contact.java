package com.exochain.ice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

import com.exochain.ice.ContactID;

@Getter @Setter
public class Contact {
    private String address = "";
    private String email = "";
    private String name = "";
    private String phone = "";
    private ContactID id;
    public Contact() {
        // All fields already initiliazed by inline defaults
        id = null;
    }
    public Contact(String prefix, HashMap<String, String> formData) {
        String p = prefix + ":";
        address    = formData.get(p+"address");
        email      = formData.get(p+"email");
        name       = formData.get(p+"name");
        phone      = formData.get(p+"phone");
        String sid = formData.get(p+"id");
        id = sid.isEmpty() ? null : new ContactID(sid);
    }
    // I initially thought to store contactType here, to make displaying the
    // type easier for clients. But then I realized, that should lie in the
    // client, and we don't want that redundant data serialized everwhere
    private boolean isEmpty() {
        return address.isEmpty() &&
                email.isEmpty() &&
                name.isEmpty() &&
                phone.isEmpty();
    }
    // Initialize this contact with a random ID, iff the contact is not empty
    // and doesn't already have one
    // OR the parameter "force" is true
    public void initialize(boolean force) {
        if ((!isEmpty() && id == null) || force) {
            id = new ContactID();
        }
    }
    // Don't force by default
    public void initialize() {
        initialize(false);
    }
}

