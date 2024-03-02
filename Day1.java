import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class Day1 {
    public static void part1() {
        try {
            // Initialize variables
            Path input = Paths.get("Day1.txt");
            Scanner scanner = new Scanner(input);
            int total = 0;
            // Iterate through each line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
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
            scanner.close();
            System.out.println("Final total: " + total);
        } catch (IOException e) {
            System.out.println("Caught exception: " + e);
        }
    }

    public static void part2() {
        try {
            // Initialize variables
            Path input = Paths.get("Day1.txt");
            Scanner scanner = new Scanner(input);
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
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
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
            scanner.close();
            System.out.println("Final total: " + total);
        } catch (IOException e) {
            System.out.println("Caught exception: " + e);
        }
    }
    public static void main(String[] args) {
        //part1();
        part2();
    }
}