package Day4;
import java.util.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Part1 {
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
            Path input = Paths.get("Day4.txt");
            Scanner scanner = new Scanner(input);
            int total = 0;

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String numbers = line.split(":")[1].trim();
                String[] winningNumbers = (numbers.split("\\|")[0].trim()).split(" ");
                String[] pulledNumbers = (numbers.split("\\|")[1].trim()).split(" ");
                int matches = 0;
                
                // Remove whitespace from arrays
                ArrayList<String> pulledNumbersFixed = fixWhiteSpace(pulledNumbers);
                ArrayList<String> winningNumbersFixed = fixWhiteSpace(winningNumbers);

                // Get winning numbers
                for (String s : pulledNumbersFixed) {
                    if (winningNumbersFixed.contains(s)) {
                        matches += 1;
                    }
                }

                // Add matches to total
                if (matches > 0) {
                    total += Math.pow(2, matches - 1);
                }
            }
            
            System.out.println("Total: " + total);
            scanner.close();

        } catch (IOException e) {
            System.out.println("Exception:" + e);
        }
    }
}