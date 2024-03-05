package util;

import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class AOC {
    public static ArrayList<String> readFile (String inputPath) {
        ArrayList<String> lines = new ArrayList<>();
        Path input = Paths.get(inputPath);
        try (Scanner scanner = new Scanner(input)) {

            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }

        } catch (IOException e) {
            System.out.println("IOException");
        }
        return lines;
    }

    public static ArrayList<String> fixWhiteSpace(String[] numbers) {
        ArrayList<String> fixedNumbers = new ArrayList<String>();

        for (String s : numbers) {
            if (s.trim().length() > 0) {
                fixedNumbers.add(s);
            }
        }

        return fixedNumbers;
    }
}