package Day6;
import java.util.*;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Part2 {
    public static BigInteger getNumber(String info) {
        List<String> sData = Arrays.asList(info.split(":\\s+")[1].split("\\s+"));
        String data = "";
        for (String s : sData) {
            data += s;
        }

        BigInteger output = new BigInteger(data);
        return output;
    }

    public static BigInteger calcPossibilities(BigInteger totalTime, BigInteger recordDistance) {
        BigInteger speed = BigInteger.valueOf(0); // duration button is held
        BigInteger distance = BigInteger.valueOf(0); // total distance traveled
        BigInteger time = BigInteger.valueOf(0); // amount of time left after button is held
        BigInteger total = BigInteger.valueOf(0); // number of possibilities

        // Check all permutations
        for (BigInteger i = BigInteger.valueOf(0); i.compareTo(totalTime) < 1; i = i.add(BigInteger.ONE)) {
            speed = i;
            time = totalTime.subtract(speed);
            distance =  time.multiply(speed);
            
            if (distance.compareTo(recordDistance) == 1) {
                total = total.add(BigInteger.ONE);
            }
        }
        return total;
    }
    public static void main(String[] args) {
        try {
            // Initialize variables
            Path input = Paths.get("Day6/Input.txt");
            Scanner scanner = new Scanner(input);
            String timeInput = scanner.nextLine();
            String distanceInput = scanner.nextLine();
            BigInteger total;

            // Get time & distance
            BigInteger time = getNumber(timeInput);
            BigInteger distance = getNumber(distanceInput);

            total = calcPossibilities(time, distance);

            System.out.println("Time: " + time);
            System.out.println("Distance: " + distance);
            System.out.println("Total: " + total);
            scanner.close();
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
