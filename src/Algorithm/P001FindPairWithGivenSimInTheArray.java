package Algorithm;

import java.util.HashSet;
import java.util.Set;

public class P001FindPairWithGivenSimInTheArray {
    public static void main(String[] args) {
        int[] array = new int[] { 5, 8, 7, 2, 3, 1 };
        new P001FindPairWithGivenSimInTheArray().solve(array, 10);
    }

    public void solve(int[] array, int target) {
        Set<Integer> integersSet = new HashSet<>();
        boolean foundSolution = false;
        for(int i=0; i<array.length; i++) {
            integersSet.add(array[i]);
        }
        for(int i=0; i<array.length; i++) {
            int noToFind = target - array[i];
            if(integersSet.contains(noToFind)) {
                System.out.printf("\nFound " + array[i] + ", " + noToFind);
                foundSolution = true;
                break;
            }
        }

        if(!foundSolution) {
            System.out.printf("Not Found");
        }
    }
}