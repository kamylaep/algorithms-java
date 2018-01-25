import java.util.Arrays;
import java.util.stream.Collectors;

public class Anagram {

    public boolean isAnagram(String a, String b) {
        if (a.replace(" ", "").length() != b.replace(" ", "").length()) {
            return false;
        }

        String collectA = getCollect(a);
        String collectB = getCollect(b);

        return collectA.equalsIgnoreCase(collectB);
    }

    private String getCollect(String w) {
        return Arrays.stream(w.split("")).filter(f -> !f.equals(" ")).sorted().collect(Collectors.joining());
    }

}
