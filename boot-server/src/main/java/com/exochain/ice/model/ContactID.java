package com.exochain.ice;

import com.fasterxml.jackson.annotation.JsonValue;

public class ContactID {
    private String id;
    public ContactID() {
        // TODO: Use proper ids here
        id = Integer.toString((int)(Math.random()*1000));
    }
    @JsonValue
    public String toString() {
        return id;
    }
}

