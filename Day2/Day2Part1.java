import util.AOC;
import java.util.ArrayList;

public class Day2Part1 {
    // For Part 1
    public static int getColorNumber(String pull, String color) {
        String[] cubes = pull.trim().split(",");
        for (String s : cubes) {
            if(s.contains(color)) {
                String number = s.trim().split(" ")[0];
                return Integer.parseInt(number);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        final int MAX_RED = 12, MAX_BLUE = 14, MAX_GREEN = 13;
        ArrayList<String> lines = AOC.readFile("Day2/Input.txt");
        int total = 0;
        int currentGame = 1;

        // Iterate through each line (game)
        for (String line : lines) {
            String gameResults = line.split(":")[1];
            String[] pulls = gameResults.split(";");
            boolean isPossible = true;
            
            // For each pull in a game, get amount of colored blocks
            for (String i : pulls) {
                int currentRed = 0, currentBlue = 0, currentGreen = 0;
                currentRed = getColorNumber(i, "red");
                currentBlue = getColorNumber(i, "blue");
                currentGreen = getColorNumber(i, "green");
                // if any current number bigger than max, game is not possible
                if (currentRed > MAX_RED || currentBlue > MAX_BLUE || currentGreen > MAX_GREEN) {
                    isPossible = false;
                    break;
                } else {
                    isPossible = true;
                }
            }

            if(isPossible) {
                System.out.println("Game " + currentGame + " IS possible");
                total += currentGame;
            } else {
                System.out.println("Game " + currentGame + " is NOT possible");
            }
            currentGame++;
        }

        System.out.println("Total: " + total);
    }
}