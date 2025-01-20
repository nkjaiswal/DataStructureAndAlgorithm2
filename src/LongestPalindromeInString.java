class LongestPalindromeInString {

    public static String find(String input) {
        if(input == null) {
            return null;
        }
        int n = input.length();
        int[][] matrix = new int[n][n];
        int max = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for(int length=1; length<=n; length ++) {
            for(int j=0; j<=n-length; j++) {
                if(length > 2) {
                    if(matrix[j+1][j+length-2] == 0) {
                        matrix[j][j+length-1] = 0;
                        continue;
                    }
                }
                if(input.charAt(j) == input.charAt(j+length-1)) {
                    if(max < length) {
                        max = length;
                        maxStart = j;
                        maxEnd = j+length;
                    }
                    matrix[j][j+length-1] = 1;
                }
            }
        }
        return input.substring(maxStart, maxEnd);
    }


    public static void main(String[] args) {
        System.out.println(find("cbbd"));
        System.out.println(find("aba"));
        System.out.println(find("nishantna"));
        System.out.println(find(null));
    }
}
