package Day1;

import util.AOC;
import java.util.ArrayList;

public class Part1 {
 public static void main(String[] args) {
        // Initialize variables
        ArrayList<String> lines = AOC.readFile("Day1/Input.txt");
        int total = 0;
        for (String line : lines) {
            String number = "";
            // Check first number
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    number += line.charAt(i);
                    break;
                }
            }
            // Check second number
            for (int i = line.length() - 1; i >= 0; i--) {
                if (Character.isDigit(line.charAt(i))) {
                    number += line.charAt(i);
                    break;
                }
            }
            total += Integer.parseInt(number);
            System.out.println(line + " - " + number);
        }
        System.out.println("Final total: " + total);
    }
}