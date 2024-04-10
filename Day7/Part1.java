package Day7;

import util.AOC;
import java.util.ArrayList;
import java.util.Collections;

public class Part1 {
    public static void main(String[] args) {
        ArrayList<String> lines = AOC.readFile("Day7/Input.txt");
        ArrayList<Hand> hands = new ArrayList<>();
        int total = 0;

        // Parse each card
        for (String line : lines) {
            Hand hand = new Hand(line);
            hands.add(hand);
        }

        Collections.sort(hands);

        // Calculate total
        for (int i = 0; i < hands.size(); i++) {
            Hand hand = hands.get(i);
            total += (hand.bet * (i + 1));
        }

        System.out.println("Total: " + total);
    }
}