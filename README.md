# Hangman (Java + JavaFX)

A simple Hangman game implemented in Java.  
The project includes both a console version and a JavaFX GUI version.

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