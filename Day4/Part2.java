package Day4;
import java.util.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Part2 {
    public static ArrayList<String> fixWhiteSpace(String[] numbers) {
        ArrayList<String> fixedNumbers = new ArrayList<String>();

        for (String s : numbers) {
            if (s.trim().length() > 0) {
                fixedNumbers.add(s);
            }
        }

        return fixedNumbers;
    }
    public static void main(String[] args) {
        try {
            Path input = Paths.get("Day4/Input.txt");
            Scanner scanner = new Scanner(input);
            ArrayList<Card> cards = new ArrayList<>();
            int total = 0;
            
            // Create card list
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String numbers = line.split(":")[1].trim();
                String[] winningNumbers = (numbers.split("\\|")[0].trim()).split(" ");
                String[] pulledNumbers = (numbers.split("\\|")[1].trim()).split(" ");
                
                // Remove whitespace from arrays
                ArrayList<String> pulledNumbersFixed = fixWhiteSpace(pulledNumbers);
                ArrayList<String> winningNumbersFixed = fixWhiteSpace(winningNumbers);

                Card thisCard = new Card();
                thisCard.winningNumbers = winningNumbersFixed;
                thisCard.pulledNumbers = pulledNumbersFixed;
                cards.add(thisCard);
            }

            // Find matches and add cards
            for (int i = 0; i < cards.size(); i++) {
                Card thisCard = cards.get(i);
                thisCard.pulledNumbers.retainAll(thisCard.winningNumbers);

                for (int x = 0; x < thisCard.pulledNumbers.size(); x++) {
                    Card nextCard = cards.get(i + x + 1);
                    nextCard.count += thisCard.count;
                }
            }

            for (Card card : cards) {
                total += card.count;
            }

            System.out.println("Total: " + total);
            scanner.close();
        } catch (IOException e) {
            System.out.println("Exception:" + e);
        }
    }
}
