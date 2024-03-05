package Day1;

import java.util.ArrayList;
import java.util.HashMap;
import util.AOC;

public class Part2 {
    public static void main(String[] args) {
        // Initialize variables
        ArrayList<String> lines = AOC.readFile("Day1/Input.txt");
        int total = 0;
        HashMap<String, String> numberMap = new HashMap<String, String>();
        numberMap.put("0", "zero");
        numberMap.put("1", "one");
        numberMap.put("2", "two");
        numberMap.put("3", "three");
        numberMap.put("4", "four");
        numberMap.put("5", "five");
        numberMap.put("6", "six");
        numberMap.put("7", "seven");
        numberMap.put("8", "eight");
        numberMap.put("9", "nine");

        // Iterate through each line
        for (String line : lines) {
            String tempNumber = "";
            String number = "";
            boolean flag = false;

            // Check first number
            for(int i = 0; i < line.length(); i++) {
                if(!flag) {
                    tempNumber += line.charAt(i);
                    for (String s : numberMap.keySet()) {
                        // Check if tempNumber is number
                        if(tempNumber.contains(s)) {
                            number += s;
                            flag = true;
                        // Check if tempNumber is word
                        } else if (tempNumber.contains(numberMap.get(s))) {
                            number += s;
                            flag = true;
                        }
                    }
                } else {
                    break;
                }
            }

            tempNumber = "";
            flag = false;

            // Check second number
            for(int i = line.length() - 1; i >= 0; i--) {
                tempNumber = line.charAt(i) + tempNumber;
                if(!flag) {
                    for (String s : numberMap.keySet()) {
                        // Check if tempNumber is number
                        if(tempNumber.contains(s)) {
                            number += s;
                            flag = true;
                        // Check if tempNumber is word
                        } else if (tempNumber.contains(numberMap.get(s))) {
                            number += s;
                            flag = true;
                        }
                    }
                } else {
                    break;
                }
            }

            total += Integer.parseInt(number);
            System.out.println(line + " - " + number);
        }
        System.out.println("Final total: " + total);
    }
}