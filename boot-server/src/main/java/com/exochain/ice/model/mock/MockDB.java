package com.exochain.ice.model.mock;

import java.util.Map;
import java.util.HashMap;

import com.exochain.ice.model.Card;

public class MockDB {
    
		private Map<String, Card> cards;

		public MockDB() {
				cards = new HashMap<String, Card>();
		}

		public Card getCard(String id) {
				return cards.get(id);
		}
		public String addCard(Card card) {
				String id = Integer.toString((int)(Math.random()*1000));
				cards.put(id, card);
				return id;
		}

}

