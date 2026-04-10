import java.util.*;

public class MyStringProcessing {

    public static String format(String raw) {
        raw = raw.strip();

        String[] words = raw.split("\\s+");

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
        }

        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String raw = "   hellO   AMAZING   wOrld   !!!  ";

        String result = format(raw);
        System.out.println(result);
    }
}