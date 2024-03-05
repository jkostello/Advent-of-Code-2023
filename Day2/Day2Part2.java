import util.AOC;
import java.util.ArrayList;

public class Day2Part2 {
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

    public static void main(String[] args) {
        ArrayList<String> lines = AOC.readFile("Day2/Input.txt");
        int total = 0;

        // Iterate through each line (game)
        for (String line : lines) {
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
    }
}
