package org.example;

import Controller.GameController;

public class Main {
    public static void main(String[] args) {
        int playerCount = 3;

        GameController gameController = new GameController(playerCount);
        int winner = gameController.playGame();

        System.out.println("Game over!");
        System.out.println("Winning player: Player " + winner);
    }
}