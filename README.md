# Hangman (Java + JavaFX)

A simple Hangman game implemented in Java.  
The project includes both a console version and a JavaFX GUI version.

## Files

Hangman_GUI/
│
├── Hangman.java # Core game logic (word state, attempts, checking guesses)
├── HangmanGUI.java # JavaFX interface for playing hangman visually
├── WordList.java # Loads words from file and returns a random word
│
├── words.txt # List of words used by the game
├── javafx-sdk-25.0.1/ # JavaFX library (required to run the GUI)
└── .vscode/ # VS Code settings for JavaFX run configuration

## How It Works

- `WordList` loads a list of words from `words.txt`.
- `Hangman` holds the game state:
  - chosen word  
  - guessed letters  
  - max attempts  
  - revealed letters  
- `HangmanGUI` displays:
  - difficulty selection  
  - current word as underscores  
  - input text field  
  - guess history and messages  

## Notes

- All words should be lowercase in `words.txt`.
- The JavaFX SDK folder must stay inside the project directory.
- If imports show errors, check that the `javafx-sdk-25.0.1/lib/*.jar` files are referenced in `.vscode/settings.json`.