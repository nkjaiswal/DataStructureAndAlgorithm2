import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatingCharLength {
    public static int find(String str) {
        Set<Character> set = new HashSet<>();
        int pointer = 0;
        int left = 0;
        int max = 0;
        while(pointer<str.length()) {
            Character c = str.charAt(pointer++);
            while(set.contains(c)) {
                set.remove(str.charAt(left++));
            }
            set.add(c);
            max = Math.max(max, set.size());
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(find("thisisatest"));
        String s1 = "abcabcbb";
        System.out.println(find(s1)); // Output: 3

        // Example 2
        String s2 = "bbbbb";
        System.out.println(find(s2)); // Output: 1

        // Example 3
        String s3 = "pwwkew";
        System.out.println(find(s3)); // Output: 3
    }
}
