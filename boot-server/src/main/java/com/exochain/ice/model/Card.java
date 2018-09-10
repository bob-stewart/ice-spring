package com.exochain.ice.model;

import java.util.HashMap;
import com.exochain.ice.model.PublicContactList;
import com.exochain.ice.model.KeyData;
import com.exochain.ice.model.EncryptedString;
// import com.exochain.ice.model.AsymmetricEncryptedString;
class AsymmetricEncryptedString extends EncryptedString {
    AsymmetricEncryptedString(String s) {
        super(s);
    }
} // TODO

public class Card {
    public PublicContactList contacts;
    public String notes;
    public EncryptedString secure;
    public HashMap<String, AsymmetricEncryptedString> escrow;
    public KeyData keyData;
    // Initializes the card for the database. Mostly just delegates
    public void initialize() {
        contacts.initialize();
    }
}

