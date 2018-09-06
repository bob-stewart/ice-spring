package com.exochain.model;

import java.util.Map;
import com.exochain.model.KeyData;
import com.exochain.model.EncryptedString;
// import com.exochain.model.AsymmetricEncryptedString;
class AsymmetricEncryptedString {} // TODO

public class Card {
    public Contact[] contacts;
    public String notes;
    public EncryptedString secure;
    public Map<String, AsymmetricEncryptedString> escrow;
    public KeyData keyData;
}

