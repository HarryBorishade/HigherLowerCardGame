package hlcg.HigherLower;
import java.util.*;

import hlcg.enums.Rank;
import hlcg.enums.Suit;
import hlcg.interfaces.*;

public class Deck implements CardCollection{
	private List<Card> cards;

	 public Deck() {
	        cards = new ArrayList<>();
	        initialiseDeck();
	        shuffle();
	    }
	 
	 private void initialiseDeck() {
	 
		 for(Suit suit: Suit.values()) {
			 for(Rank rank: Rank.values()) {
				 cards.add(new Card(rank,suit));
			 }
		 }
	 
	 }
	 public void shuffle() {
		 Collections.shuffle(cards);
	 }
	 
	 public Card drawCard() {
		 if(isEmpty()) {
			 throw new IllegalStateException("Deck is empty");
		 }
		 return cards.remove(0);
	 }

	@Override
	public String deckPeak() {
		if (isEmpty()) {
			return "Deck is empty";
		}
		return cards.get(0).toString();
	}

	@Override
	public boolean isEmpty() {
		if (this.cards.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public Integer numberOfCards() {
		if(cards.isEmpty()) {
			return 0;
		}
		return cards.size();
	}
	
	public static void main(String[] args) {
		Deck deck1 = new Deck();
		for(int i =0; i < 52; i++) {
			Card card = deck1.drawCard();
			System.out.println(card);
		}
	}
}