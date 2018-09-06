package com.exochain.ice.model;

import com.exochain.ice.model.EncryptedString;

public class KeyData {
    public String publicKey;
    public String privateKey;
    public EncryptedString encryptedPrivateKey;
    public String passKey;
    public KeyData(String privateKey) {
        passKey = "hi there"; // TODO Generate random passKey
        encryptedPrivateKey = new EncryptedString(privateKey);
        publicKey = "derive public from private here TODO";
        this.privateKey = privateKey;
    }
}

