package hlcg.HigherLower;

import java.util.*;

public class Player {

    private String name;
    private List<Card> cards;
    private int score;

    // Constructor
    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
        this.score = 0;
    }

    // Basic getters 

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards); // protects internal list
    }

    // Score management 

    public void increaseScore() {
        score++;
    }

    public void resetScore() {
        score = 0;
    }

    // Card management 

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card getLastCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.get(cards.size() - 1);
    }

    public void resetHand() {
        cards.clear();
    }

    public int getHandSize() {
        return cards.size();
    }

    // --- Display methods ---

    public String showCardsPicked() {
        if (cards.isEmpty()) {
            return name + " has no cards.";
        }

        StringBuilder cardOutput = new StringBuilder();
        cardOutput.append(name).append("'s cards:\n");

        for (Card card : cards) {
            cardOutput.append(card).append("\n");
        }

        return cardOutput.toString();
    }

    @Override
    public String toString() {
        return name + " (Score: " + score + ")";
    }
}