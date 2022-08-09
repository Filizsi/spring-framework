import org.jetbrains.annotations.NotNull;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class Assignment6FindFirstNonRepeatingChar {
    public static void main(String[] args) {
        System.out.println(findFirstNonRepeatingChar("a green apple"));
    }
    public static char findFirstNonRepeatingChar(@NotNull String str){
        // create hashmap for char and its count
        Map<Character,Integer> map=new HashMap<>();
        int count=0;
        var chars=str.toCharArray();
        // O(n)
        for(Character ch: chars) {
            if (map.containsKey(ch)) {
                count=map.get(ch);
                map.put(ch, count+1);
            }else {// first time we see ch
                map.put(ch,1);
            }
        }
        // O(n)
        for(Character ch: chars){
            if (map.get(ch)==1) return ch;
        }
        // O(n) + O(n) = O(2n) => O(n)
        return Character.MIN_VALUE;
    }

}
