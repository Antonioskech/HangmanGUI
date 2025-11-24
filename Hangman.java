import java.util.HashSet;
import java.util.Set;

public class Hangman {
    private Set<Character> set = new HashSet<>();
    private String word;
    private StringBuilder guessedWord;
    private int attemptsLeft;

    public Hangman() {
        WordList.readWordsFromFile();
        this.word = WordList.getRandomWord();
        this.guessedWord = new StringBuilder("_".repeat(word.length()));
    }

    public void setDifficulty(int diff) {
        switch (diff) {
            case 1: attemptsLeft = 10; break;
            case 2: attemptsLeft = 7; break;
            case 3: attemptsLeft = 4; break;
            default: attemptsLeft = 6;
        }
    }

    public String makeGuess(char c) {
        if (set.contains(c)) {
            return "You already guessed that letter!";
        }
        set.add(c);

        boolean found = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                guessedWord.setCharAt(i, c);
                found = true;
            }
        }

        if (!found) {
            attemptsLeft--;
            return "The letter '" + c + "' is not in the word!";
        }

        return "Good guess!";
    }

    public String getGuessedWord() {
        return guessedWord.toString();
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public boolean isWon() {
        return guessedWord.indexOf("_") == -1;
    }

    public boolean isLost() {
        return attemptsLeft <= 0;
    }

    public String getWord() {
        return word;
    }
}
