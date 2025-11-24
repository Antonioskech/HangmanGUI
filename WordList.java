import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public final class WordList {
    private static List<String> words = new ArrayList<>();
    private static String filename = "words.txt";

    public static void readWordsFromFile() {
        if (!words.isEmpty()) return;
        
        try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNext()) {
                words.add(sc.next().toLowerCase());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Word file not found!");
        }
    }

    private WordList() {}

    public static String getRandomWord() {
        if (words.isEmpty()) return "default";
        return words.get(new Random().nextInt(words.size()));
    }
}
