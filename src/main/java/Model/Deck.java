package Model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<>();
        for(int i = 2; i <= 14; i++){
            for(Suite s : Suite.values()){
                deck.add(new Card(s, i));
            }
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

}
