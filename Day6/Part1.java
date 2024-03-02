package Day6;
import java.util.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Part1 {
    public static List<Integer> getList(String info) {
        List<String> sData = Arrays.asList(info.split(":\\s+")[1].split("\\s+"));
        List<Integer> data = new ArrayList<>();

        for (String s : sData) {
            data.add(Integer.parseInt(s));
        }

        return data;
    }

    public static int calcPossibilities(int totalTime, int recordDistance) {
        int speed = 0; // duration button is held
        int distance = 0; // total distance traveled
        int time = 0; // amount of time left after button is held
        int total = 0; // number of possibilities
        for (int i = 1; i < totalTime; i++) {
            speed = i;
            time = totalTime - speed;
            distance =  time * speed;
            
            if (distance > recordDistance) {
                total++;
            }
        }

        return total;
    }
    public static void main(String[] args) {
        try {
            // Initialize variables
            Path input = Paths.get("Day6/Input.txt");
            Scanner scanner = new Scanner(input);
            String time = scanner.nextLine();
            String distance = scanner.nextLine();
            int total = 1;

            List<Integer> times = getList(time);
            List<Integer> distances = getList(distance);

            for (int i = 0; i < times.size(); i++) {
                total*= calcPossibilities(times.get(i), distances.get(i));
            }

            System.out.println("Total: " + total);
            scanner.close();
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}
