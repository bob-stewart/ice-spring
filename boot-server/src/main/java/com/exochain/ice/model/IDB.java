package com.exochain.ice;

import com.exochain.ice.model.Card;

public interface IDB {
    public Card getCard(String id);
    public String addCard(Card card);
    public void updateCard(String id, Card card);
}

