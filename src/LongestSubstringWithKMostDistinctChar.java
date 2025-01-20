class LongestSubstringWithKMostDistinctChar {

    public static int find(String input, int k) {
        if(input == null) {
            return 0;
        }
        int distinctCount = 0;
        int[] countMap = new int[128];
        int low = -1;
        int high = 0;
        int maxCount = 0;
        while(low < high && high < input.length()) {

                char currentChar = input.charAt(high++);
                if(countMap[currentChar] == 0) {
                    distinctCount ++;
                }
                countMap[currentChar]++;


            if(distinctCount <= k) {
                maxCount = Math.max(maxCount, high-1-low);
            }
            while(distinctCount > k && low < high) {
                low++;
                char charToRemove = input.charAt(low);
                countMap[charToRemove]--;
                if(countMap[charToRemove] == 0) {
                    distinctCount--;
                }
            }
        }
        return maxCount;
    }
    public static void main(String[] args) {
        System.out.println(find("eceba", 2));
        System.out.println(find("aaaaaaaabbbbbbbbeeeeeeeeeeeeeee", 2));
    }
}
