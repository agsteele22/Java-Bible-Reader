import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class RandomBibleVerseGenerator {

    public static void main(String[] args) {
        try {
            List<String> bibleVerses = readBibleVersesFromFile("365_Bible_Verses(1).pdf");
            String randomVerse = getRandomVerse(bibleVerses);
            System.out.println("Random Bible Verse: " + randomVerse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readBibleVersesFromFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readAllLines(path);
    }

    private static String getRandomVerse(List<String> verses) {
        Random random = new Random();
        int randomIndex = random.nextInt(verses.size());
        return verses.get(randomIndex);
    }
}
