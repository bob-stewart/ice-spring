
package com.exochain.ice.model;

import com.fasterxml.jackson.annotation.JsonValue;

public class EncryptedString {
    private String encrypted;
    public EncryptedString(String plaintext) {
        encrypted = plaintext + ", but encrypted ;)"; // TODO
    }
    @JsonValue
    public String toString() {
        return encrypted;
    }
}

