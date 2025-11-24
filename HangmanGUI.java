import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HangmanGUI extends Application {

    private Hangman game;
    private Text wordLabel;
    private Text attemptsLabel;
    private TextField inputField;
    private Label messageLabel;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Hangman Game");

        // Difficulty selection screen
        Scene difficultyScene = buildDifficultyScene(stage);

        stage.setScene(difficultyScene);
        stage.show();
    }

    private Scene buildDifficultyScene(Stage stage) {
        VBox box = new VBox(20);
        box.setAlignment(Pos.CENTER);

        Text title = new Text("Choose Difficulty");
        title.setFont(Font.font(24));

        Button easy = new Button("Easy (10 attempts)");
        Button medium = new Button("Medium (7 attempts)");
        Button hard = new Button("Hard (4 attempts)");

        easy.setOnAction(e -> startGame(stage, 1));
        medium.setOnAction(e -> startGame(stage, 2));
        hard.setOnAction(e -> startGame(stage, 3));

        box.getChildren().addAll(title, easy, medium, hard);
        return new Scene(box, 400, 300);
    }

    private void startGame(Stage stage, int difficulty) {
        game = new Hangman();
        game.setDifficulty(difficulty);

        wordLabel = new Text(game.getGuessedWord());
        wordLabel.setFont(Font.font(26));

        attemptsLabel = new Text("Attempts left: " + game.getAttemptsLeft());
        attemptsLabel.setFont(Font.font(18));

        messageLabel = new Label("");

        inputField = new TextField();
        inputField.setPromptText("Enter a letter");
        inputField.setMaxWidth(120);

        Button guessBtn = new Button("Guess");
        guessBtn.setOnAction(e -> handleGuess());

        VBox layout = new VBox(20, wordLabel, attemptsLabel, inputField, guessBtn, messageLabel);
        layout.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(layout, 450, 350));
        stage.show();
    }

    private void handleGuess() {
        String text = inputField.getText().toLowerCase();
        inputField.clear();

        if (text.length() != 1 || !Character.isLetter(text.charAt(0))) {
            messageLabel.setText("Enter a single letter a-z!");
            return;
        }

        char c = text.charAt(0);
        String result = game.makeGuess(c);

        wordLabel.setText(game.getGuessedWord());
        attemptsLabel.setText("Attempts left: " + game.getAttemptsLeft());
        messageLabel.setText(result);

        if (game.isWon()) {
            messageLabel.setText("🎉 You win! The word was: " + game.getWord());
            inputField.setDisable(true);
        } else if (game.isLost()) {
            messageLabel.setText("💀 You lost! The word was: " + game.getWord());
            inputField.setDisable(true);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
