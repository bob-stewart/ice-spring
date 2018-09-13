package com.exochain.ice.model;

import lombok.Getter;
import lombok.Setter;

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

@Getter @Setter
public class Card {
    private PublicContactList contacts;
    private String notes;
    private EncryptedString secure;
    private HashMap<String, AsymmetricEncryptedString> escrow;
    private KeyData keyData;
    public Card(HashMap<String, String> formData) {
        contacts = new PublicContactList(formData);
        notes = formData.get("notes");
    }
    // Initializes the card for the database. Mostly just delegates
    public void initialize() {
        contacts.initialize();
    }
}

