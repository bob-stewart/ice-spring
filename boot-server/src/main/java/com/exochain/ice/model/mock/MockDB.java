package com.exochain.ice.model.mock;

import java.util.Map;
import java.util.HashMap;

import com.exochain.ice.model.Card;
import com.exochain.ice.ContactID;
import com.exochain.ice.IDB;

public class MockDB implements IDB {
    
    private Map<String, Card> cards;

    public MockDB() {
        cards = new HashMap<String, Card>();
    }

    public Card getCard(String id) {
        return cards.get(id);
    }
    public String addCard(Card card) {
        card.initialize();
        // For now, in keeping with ice-node's convention, we use our ContactID
        // as the Card ID
        String id = card.contacts.you.id.toString();
        cards.put(id, card);
        return id;
    }
    public void updateCard(String id, Card card) {
        cards.put(id, card);
    }

}

