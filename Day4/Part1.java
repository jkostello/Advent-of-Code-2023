package Day4;

import util.AOC;
import java.util.ArrayList;

public class Part1 {
    public static void main(String[] args) {
        ArrayList<String> lines = AOC.readFile("Day4/Input.txt");
        int total = 0;

        for (String line : lines) {
            String numbers = line.split(":")[1].trim();
            String[] winningNumbers = (numbers.split("\\|")[0]).split(" ");
            String[] pulledNumbers = (numbers.split("\\|")[1]).split(" ");
            int matches = 0;
            
            // Remove whitespace from arrays
            ArrayList<String> pulledNumbersFixed = AOC.fixWhiteSpace(pulledNumbers);
            ArrayList<String> winningNumbersFixed = AOC.fixWhiteSpace(winningNumbers);

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
    }
}