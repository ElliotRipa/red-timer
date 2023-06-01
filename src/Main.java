import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Create an empty instant.
        Instant totalTime = Instant.parse("0000-01-01T00:00:00.000Z");

        // Read file.
        ArrayList<String> file = FileReader.readFile("input/times.txt");

        // Make sure the file exists. Mostly just to make IDE stop complaining.
        assert file != null;

        // For every line.
        for (String line: file) {

            // Add minutes.
            totalTime = totalTime.plus(intAt(line, line.length()-7, line.length()-7), ChronoUnit.MINUTES);

            // Add seconds.
            totalTime = totalTime.plus(intAt(line, line.length()-5, line.length()-4), ChronoUnit.SECONDS);

            // Add milliseconds. Multiply by 10 because file is in hundredths.
            totalTime = totalTime.plus(intAt(line, line.length()-2, line.length()-1) * 10L, ChronoUnit.MILLIS);

            // System.out.println(line);
        }

        System.out.println(totalTime);

    }

    // Interprets a part of a string as an int.
    static int intAt(String num, int startIndex, int endIndex)
    {
        return Integer.parseInt(num.substring(startIndex, endIndex+1));
    }

}
