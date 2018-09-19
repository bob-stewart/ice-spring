package com.exochain.ice;

import com.exochain.ice.EncryptedString;

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

