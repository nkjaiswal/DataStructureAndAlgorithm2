package Algorithm;

public class ShareSellProfit {
    public static void main(String[] args) {
        int[] A = {5030607, 3485715, 2500526, 676233, 7968122, 7455631, 2382510};
        System.out.println(new ShareSellProfit().maxProfit(A));
    }

    public int maxProfit(final int[] A) {
        int n = A.length;
        if(n <= 1){
            return 0;
        }
        int maxProfitRes = 0;
        for(int i=0; i<n; i++) {
            maxProfitRes = Math.max(maxProfitRes, profit(A, 0, i) + profit(A, i+1, n-1));
        }
        return maxProfitRes;
    }

    public int profit(final int[] A, final int start, final int end) {
        int smallest[] = new int[end - start +1];
        int counter = 0;
        int lastSmall = Integer.MAX_VALUE;
        for(int i=start; i<=end; i++) {
            System.out.println(A[i]);
            smallest[counter] = Math.min(lastSmall, A[i]);
            counter++;
        }
        System.out.println(smallest[0]);
        int maxDiff = 0;
        int max = A[end];
        for(int i=counter-1; i>=0; i--) {
            max = Math.max(max, A[start + i]);
            maxDiff = Math.max(maxDiff, max - smallest[i]);
        }
        System.out.println(start + "-" + end + "=" + maxDiff);
        return maxDiff;
    }
}
