package Model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int id;
    private PlayerHand playerHand;

    public Player() {
        this.id = (int)Math.floor(Math.random()*10);
    }

    public Player(ArrayList<Card> cards) {
        this.id = (int)Math.floor(Math.random()*10);
        this.playerHand = new PlayerHand(cards);
    }


    public Card getTopCard() {
        return this.playerHand.getCard();
    }

    public void addCard(Card card) {
        this.playerHand.addCard(card);
    }

    public void addCards(List<Card> cards) {
        for (Card card : cards) {
            this.playerHand.addCard(card);
        }
    }

    public PlayerHand getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(PlayerHand playerHand) {
        this.playerHand = playerHand;
    }

    public int getId() {
        return id;
    }
}
