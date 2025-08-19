package Controller;

import Model.Card;
import Model.Deck;
import Model.Player;
import Model.PlayerHand;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private Deck deck;
    private List<Player> players;
    private int playerCount;

    public GameController(int playerCount) {
        this.playerCount = playerCount;
        deck = new Deck();
        players = new ArrayList<>();
        prepareGame();
    }

    private void prepareGame() {
        deck.shuffle();
        List<Card> fullDeck = deck.getDeck();
        int cardsPerPlayer = fullDeck.size() / playerCount;
        int remainingCards = fullDeck.size() % playerCount;

        for (int i = 0; i < playerCount; i++) {
            int start = i * cardsPerPlayer;
            int end = start + cardsPerPlayer + (i < remainingCards ? 1 : 0);
            List<Card> subList = fullDeck.subList(start, end);
            ArrayList<Card> cardsForPlayer = new ArrayList<>(subList);

            Player player = new Player(i + 1, cardsForPlayer);
            players.add(player);
        }
    }

    public int playGame() {
        boolean gameOver = false;
        int winnerId = -1;

        while (!gameOver) {
            playTurn();

            players.removeIf(player -> player.getPlayerHand().isEmpty());

            if (players.size() == 1) {
                gameOver = true;
                winnerId = players.get(0).getId();
                System.out.println("Player " + winnerId + " wins the game!");
            } else if (players.size() == 0) {
                gameOver = true;
                winnerId = -1;
                System.out.println("No winner! All players eliminated.");
            }

            validateTotalCardCount();
        }

        return winnerId;
    }


    private void playTurn() {
        List<Card> currentCards = new ArrayList<>();
        int maxRank = -1;
        List<Player> tiedPlayers = new ArrayList<>();
        List<Player> activePlayers = new ArrayList<>(players);
        for (Player player : activePlayers) {
            if (!player.getPlayerHand().isEmpty()) {
                Card card = player.getTopCard();
                currentCards.add(card);

                if (card.getRank() > maxRank) {
                    maxRank = card.getRank();
                    tiedPlayers.clear();
                    tiedPlayers.add(player);
                } else if (card.getRank() == maxRank) {
                    tiedPlayers.add(player);
                }
            }
        }

        if (tiedPlayers.size() > 1) {
            tieBreaker(currentCards, maxRank, tiedPlayers);
        } else if (tiedPlayers.size() == 1) {
            tiedPlayers.get(0).addCards(currentCards);
        }
    }

    private void tieBreaker(List<Card> cardsOnTable, int tiedRank, List<Player> tiedPlayers) {
        List<Card> tieBreakerCards = new ArrayList<>();
        int maxRank = -1;
        List<Player> newTiedPlayers = new ArrayList<>();

        List<Player> playersStillInTie = new ArrayList<>();
        for (Player player : tiedPlayers) {
            if (player.getPlayerHand().size() < tiedRank) {
                while (!player.getPlayerHand().isEmpty()) {
                    cardsOnTable.add(player.getTopCard());
                }
            } else {
                playersStillInTie.add(player);
            }
        }

        if (playersStillInTie.isEmpty()) {
            if (!tiedPlayers.isEmpty()) {
                tiedPlayers.get(0).addCards(cardsOnTable);
            }
            return;
        }

        for (Player player : playersStillInTie) {
            for (int i = 0; i < tiedRank; i++) {
                Card card = player.getTopCard();
                if (i == tiedRank - 1) {
                    tieBreakerCards.add(card);
                    if (card.getRank() > maxRank) {
                        maxRank = card.getRank();
                        newTiedPlayers.clear();
                        newTiedPlayers.add(player);
                    } else if (card.getRank() == maxRank) {
                        newTiedPlayers.add(player);
                    }
                } else {
                    cardsOnTable.add(card);
                }
            }
        }

        cardsOnTable.addAll(tieBreakerCards);

        if (newTiedPlayers.size() > 1) {
            tieBreaker(cardsOnTable, maxRank, newTiedPlayers);
        } else if (newTiedPlayers.size() == 1) {
            newTiedPlayers.get(0).addCards(cardsOnTable);
        } else {
            if (!playersStillInTie.isEmpty()) {
                playersStillInTie.get(0).addCards(cardsOnTable);
            }
        }
    }

    private void validateTotalCardCount() {
        int totalCards = 0;
        for (Player player : players) {
            totalCards += player.getPlayerHand().size();
        }
        if (totalCards != 52) {
            throw new RuntimeException("Card count mismatch! Total cards: " + totalCards);
        }
    }
}
