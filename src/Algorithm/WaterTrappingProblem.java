package Algorithm;

public class WaterTrappingProblem {
    public static void main(String[] args) {
        int[] heights = {3, 0, 1 ,0 ,4, 0, 2};
        int n = heights.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for(int i=0; i<n; i++) {
            int currentMax = i==0 ? 0 : leftMax[i-1];
            leftMax[i] = Math.max(currentMax, heights[i]);
        }

        for(int i=n-1; i>=0; i--) {
            int currentMax = i==n-1 ? 0 : rightMax[i+1];
            rightMax[i] = Math.max(currentMax, heights[i]);
        }
        print(heights);
        print(leftMax);
        print(rightMax);
        int[] trappedWater = new int[n];
        int totalWaterTrapped = 0;
        for(int i=0; i<n; i++) {
            trappedWater[i] = Math.min(leftMax[i], rightMax[i]) - heights[i];
            totalWaterTrapped = totalWaterTrapped + trappedWater[i];
        }
        print(trappedWater);
        System.out.println(totalWaterTrapped);
    }

    static void print(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
