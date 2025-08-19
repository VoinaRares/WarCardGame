# Card Game Project 🎮

This project implements a simple card game, similar to the classic game of "War," using Java. It features a game controller to manage the flow of the game, a deck of cards, and a player class to handle each player's hand.

## Game Rules 📜

The game is designed for a variable number of players, each starting with an equal number of cards from a standard 52-card deck.

### Gameplay
- Players take turns playing the top card from their hand
- The player who plays the card with the highest rank wins the round and collects all the cards played in that turn

### Ties
In the event of a tie (two or more players play cards of the same highest rank), a "tie-breaker" round occurs:
- Each tied player places a number of cards face down
- Then plays a new card face up
- The highest-ranking face-up card wins all the cards from the current and tie-breaker rounds
- This process repeats until a winner for the tie is determined

### Winning
The game ends when one player has collected all 52 cards, and they are declared the winner.

## How to Run 💻

This project is a standard Java application and can be run from any Java-compatible environment.

1. **Compile the code:** Ensure all `.java` files (`Main.java`, `GameController.java`, `Player.java`, `Deck.java`, `Card.java`, and `PlayerHand.java`) are in their correct package directories.

2. **Run the Main class:** Execute the `main` method in `org.example.Main` to start the game. You can modify the `playerCount` variable in `Main.java` to change the number of players.

## Code Structure 📂

- **`Main.java`**: The entry point of the application. It initializes and runs the game.
- **`Controller/GameController.java`**: Manages the overall game logic, including preparing the game, handling turns, and resolving tie-breakers.
- **`Model/Player.java`**: Represents an individual player. It contains the player's hand and a unique ID.
- **`Model/PlayerHand.java`**: Manages a player's collection of cards.
- **`Model/Deck.java`**: Represents the full deck of 52 cards. It handles shuffling and card distribution.
- **`Model/Card.java`**: Represents a single playing card with its rank and suit.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line

## Installation & Setup

1. Clone or download the project files
2. Ensure all Java files are in the correct package structure:
   ```
   src/
   ├── org/example/
   │   └── Main.java
   ├── Controller/
   │   └── GameController.java
   └── Model/
       ├── Player.java
       ├── PlayerHand.java
       ├── Deck.java
       └── Card.java
   ```
3. Compile the project using your preferred method

## Running the Game

### Using Command Line:
```bash
javac -d . src/org/example/*.java src/Controller/*.java src/Model/*.java
java org.example.Main
```

### Using an IDE:
1. Import the project into your IDE
2. Run the `Main.java` file
3. The game will start automatically

## Customization

- **Number of Players**: Modify the `playerCount` variable in `Main.java` to change how many players participate
- **Game Rules**: Adjust tie-breaker mechanics in `GameController.java`
- **Card Rankings**: Modify card comparison logic in `Card.java`

## Features

- ✅ Variable number of players
- ✅ Standard 52-card deck
- ✅ Automatic shuffling and card distribution
- ✅ Tie-breaker resolution
- ✅ Winner determination
- ✅ Clean object-oriented design
- ✅ Console-based gameplay

## Project Structure

The project follows a Model-Controller architecture:
- **Model**: Contains the data structures (`Card`, `Deck`, `Player`, `PlayerHand`)
- **Controller**: Contains the game logic (`GameController`)
- **Main**: Entry point and game initialization

## Future Enhancements

Potential improvements for the project:
- GUI interface using JavaFX or Swing
- Save/load game functionality
- Statistics tracking
- Different game variants
- Network multiplayer support