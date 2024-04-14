package Day7;

import util.AOC;
import java.util.ArrayList;
import java.util.Collections;

public class Part2 {
    public static void main(String[] args) {
        ArrayList<String> lines = AOC.readFile("Day7/Input.txt");
        ArrayList<Hand2> hands = new ArrayList<>();
        int total = 0;

        // Parse each card
        for (String line : lines) {
            Hand2 hand = new Hand2(line);
            hands.add(hand);
        }

        Collections.sort(hands);

        // Calculate total
        for (int i = 0; i < hands.size(); i++) {
            Hand2 hand = hands.get(i);
            total += (hand.bet * (i + 1));
        }

        System.out.println("Total: " + total);
    }
}