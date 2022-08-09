import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Assignment7FindFirstRepeatingChar {
    public static void main(String[] args) {
        System.out.println(findFirstRepeatingChar("a green apple"));
    }

    public static char findFirstRepeatingChar(@NotNull String str) {
        Set<Character> set = new HashSet<>();
        // O(n)
        var chars = str.toCharArray();
// O(n)
        for (Character ch : chars) {
            if (set.contains(ch)) {
                return ch;
            } else {// first time we see ch
                set.add(ch);
            }
        }
        return Character.MIN_VALUE;
    }
}
