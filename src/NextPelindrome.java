import java.util.Arrays;

public class NextPelindrome {
    public void solve(int[] A, int index) {
        int n = A.length-1;
        int left = A[index];
        int right = A[n-index];
        if(left > right) {
            A[n-index] = A[index];
        } else if (left < right) {
            A[n-index] = A[index];
            boolean isOverflow = true;
            int idx = n-index-1;
            while(isOverflow) {
                int element = A[idx];
                if(element == 9) {
                    A[idx--] = 0;
                } else {
                    A[idx] = element + 1;
                    isOverflow = false;
                }
            }
        }
    }
    public boolean isPelindome(int[] A, int index) {
        for(int i=index; i<A.length/2; i++) {
            if(A[i] != A[A.length - i -1]) {
                return false;
            }
        }
        return true;
    }
    public String solve(String a) {
        int[] A = new int[a.length()];
        for(int i=0; i<a.length(); i++) {
            A[i] = Integer.parseInt(a.charAt(i) + "");
        }

        if(isPelindome(A, 0)) {
            int index = A.length - 1;
            boolean shouldIncrease = true;
            while (shouldIncrease && index >= 0) {
                if(A[index] != 9) {
                    shouldIncrease = false;
                }
                A[index] = (A[index]+1)%10;
                index--;
            }
            if(shouldIncrease) {
                int[] B = new int[A.length + 1];
                B[0] = 1;
                for(int i=0; i<A.length; i++) {
                    B[i+1] = A[i];
                }
                A = B;
            }
        }
        while(!isPelindome(A, 0)) {
            for(int i=0; i<A.length/2; i++) {
                solve(A, i);
            }
        }


        boolean shouldSkipZero = true;
        StringBuilder sb = new StringBuilder();
        for (int j : A) {
            if (j == 0 && shouldSkipZero) {
                continue;
            }
            shouldSkipZero = false;
            sb.append(j);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "999";

        System.out.println(new NextPelindrome().solve(a));
    }
}
