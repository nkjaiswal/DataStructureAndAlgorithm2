public class MinLengthAnagram {

    public static int[] minLengthAnagram(String s, String t) {
        int[] tCount = new int[26];
        int nonMatchCount = 0;
        for(char c: t.toCharArray()) {
            if(tCount[c - 'a'] == 0) {
                nonMatchCount++;
            }
            tCount[c - 'a']++;
        }
        int left = -1;
        int right = 0;
        int[] sCount = new int[26];
        while(left < right) {
            if(nonMatchCount > 0 && right < s.length()) {
                char c = s.charAt(right);
                sCount[c - 'a']++;
                if(sCount[c - 'a'] == tCount[c - 'a']) {
                    nonMatchCount--;
                }
                right++;
            } else {
                if(nonMatchCount == 0) {
                    System.out.println("Found at " + (left+1) + " " + (right-1));
                }
                left++;
                if(left >= s.length()) {
                    continue;
                }
                char c = s.charAt(left);
                sCount[c - 'a']--;
                if(sCount[c - 'a'] + 1 == tCount[c - 'a']) {
                    nonMatchCount++;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        String s = "lhfdll";
        String t = "lhfdll";
        minLengthAnagram(s, t);
    }
}
