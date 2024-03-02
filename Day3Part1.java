import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day3Part1 {
    public static void main(String[] args) {
        try {
            String[] symbols = {"@", "#", "$", "%", "^", "&", "*", "=", "/"};
            Path input = Paths.get("Day3Part1Example.txt");
            Scanner scanner = new Scanner(input);

            System.out.println();

            scanner.close();
        } catch (IOException e) {
            System.out.println("Exception:" + e);
        }
    }
}
