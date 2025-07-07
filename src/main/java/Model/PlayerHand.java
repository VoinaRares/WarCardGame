package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PlayerHand {

    private Stack<Card> cards;

    public PlayerHand() {
        cards = new Stack<>();
    }

    public PlayerHand(List<Card> cards) {
        this();
        for (Card card : cards) {
            this.cards.push(card);
        }
    }

    public Card getCard() {
        return cards.pop();
    }

    public void addCard(Card card) {
        cards.push(card);
    }

    public int size() {
        return cards.size();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
