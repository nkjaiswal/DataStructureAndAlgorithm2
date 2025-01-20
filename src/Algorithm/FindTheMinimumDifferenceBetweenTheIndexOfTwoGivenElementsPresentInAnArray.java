package Algorithm;

public class FindTheMinimumDifferenceBetweenTheIndexOfTwoGivenElementsPresentInAnArray {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 4, 8, 2, 4, 3, 6, 5 };
        int x = 1, y = 6;

        int xPos = 9999;
        int yPos = -9999;
        int min = 9999;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == x) {
                xPos = i;
            }
            if(arr[i] == y) {
                yPos = i;
            }
            min = Math.min(Math.abs(xPos - yPos), min);
        }
        System.out.println(min);
    }
}
