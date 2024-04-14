package Day8;

import util.AOC;
import java.util.ArrayList;
import java.util.HashMap;

public class Part1 {
    public static void main(String[] args) {
        ArrayList<String> lines = AOC.readFile("Day8/Input.txt");
        HashMap<String, String[]> nodes = new HashMap<>();
        int steps = 0;
        boolean endReached = false;

        String directions = lines.get(0);
        lines.remove(0);
        lines.remove(0);

        // Fill out map
        for (String line : lines) {
            String[] test = line.split(" = ");
            // Get elements
            String element = test[0];
            String[] coords = test[1].split(", ");
            // Trim parentheses
            coords[0] = coords[0].substring(1);
            coords[1] = coords[1].substring(0, coords[1].length() - 1);
            nodes.put(element, coords);
        }

        String nextPosition = "AAA"; // Starting position
        int counter = 0;
        while (!endReached) {
            steps++;

            // Change to left or right coordinate
            if (directions.charAt(counter) == 'R') {
                nextPosition = nodes.get(nextPosition)[1];
            } else {
                nextPosition = nodes.get(nextPosition)[0];
            }

            // Check if final coordinate reached
            if (nextPosition.equals("ZZZ")) {
                endReached = true;
            }
            
            // Loop directions if needed
            if ((counter + 1) == directions.length()) {
                counter = 0;
            } else {
                counter++;
            }
        }

        System.out.println("Steps: " + steps);
    }
}
