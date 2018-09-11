package com.exochain.ice;

import java.lang.IllegalArgumentException;

import com.fasterxml.jackson.annotation.JsonValue;

public class ContactID {
    private String id;
    public ContactID() {
        // TODO: Use proper ids here
        id = Integer.toString((int)(Math.random()*1000));
    }
    public ContactID(String id) {
        if (!id.isEmpty()) {
            this.id = id;
        }
        else {
            throw new IllegalArgumentException("ContactID cannot be empty");
        }
    }
    @JsonValue
    public String toString() {
        return id;
    }
}

