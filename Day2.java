import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day2 {
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

    // For Part 2
    public static int getMinimumColorNumber(String pull, String color, int currentMin) {
        String[] cubes = pull.trim().split(",");
        int number = currentMin;
        for (String s : cubes) {
            if(s.contains(color)) {
                int tempNumber = Integer.parseInt(s.trim().split(" ")[0]);
                if (tempNumber > number) {
                    number = tempNumber;
                }
            }
        }
        return number;
    }

    public static void part1() {
        try {
            final int MAX_RED = 12, MAX_BLUE = 14, MAX_GREEN = 13;
            Path input = Paths.get("Day2.txt");
            Scanner scanner = new Scanner(input);
            int total = 0;
            int currentGame = 1;

            // Iterate through each line (game)
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
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
            scanner.close();
            
        } catch (IOException e) {
            System.out.println("Caught exception: " + e);
        }
    }

    public static void part2() {
        try {
            Path input = Paths.get("Day2.txt");
            Scanner scanner = new Scanner(input);
            int total = 0;

            // Iterate through each line (game)
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String gameResults = line.split(":")[1];
                String[] pulls = gameResults.split(";");
                int minimumRed = 1, minimumBlue = 1, minimumGreen = 1;
                
                // For each pull in a game, get amount of colored blocks
                for (String s : pulls) {
                    minimumRed = getMinimumColorNumber(s, "red", minimumRed);
                    minimumGreen = getMinimumColorNumber(s, "green", minimumGreen); 
                    minimumBlue = getMinimumColorNumber(s, "blue", minimumBlue);
                }

                total += minimumRed * minimumGreen * minimumBlue;
            }

            System.out.println("Total: " + total);
            scanner.close();
            
        } catch (IOException e) {
            System.out.println("Caught exception: " + e);
        }
    }

    public static void main(String[] args) {
        //part1();
        part2();
    }
}