package com.exochain.ice.model;

import java.util.Map;
import com.exochain.ice.model.KeyData;
import com.exochain.ice.model.EncryptedString;
// import com.exochain.ice.model.AsymmetricEncryptedString;
class AsymmetricEncryptedString extends EncryptedString {
    AsymmetricEncryptedString(String s) {
        super(s);
    }
} // TODO

public class Card {
    public Contact[] contacts;
    public String notes;
    public EncryptedString secure;
    public Map<String, AsymmetricEncryptedString> escrow;
    public KeyData keyData;
}

