public class BitPlay {

    public static int longestSubstringWithoutRepeatingChar(String str) {
        int low = 0;
        int high = 1;
        int state = 1<<(str.charAt(0) - 'a');
        int max = 0;
        while(low < high && high < str.length()) {
            char currentChar = str.charAt(high++);
            while((state & 1<<(currentChar-'a')) > 0) {
                char charToRemove = str.charAt(low++);
                state = state ^ 1<<(charToRemove-'a');
            }
            state = state | 1<<(currentChar-'a');
            max = Math.max(max, high-low);
        }
        return max;
    }
    public static void main(String[] args) {
        int fill = 0b01111111;
//        System.out.println(fill);
//        System.out.println(1<<3);
        System.out.println(longestSubstringWithoutRepeatingChar("abcdefghijklmnopqrstuvwxyz"));
    }
}
