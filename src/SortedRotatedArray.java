import java.util.Arrays;

public class SortedRotatedArray {

    private static int findRotationIndex(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        boolean isFirst = true;
        while(left < right) {
            int mid = (left + right) / 2;
            if(arr[mid] > arr[left] && arr[mid] > arr[right]) {
                left = mid;
            } else if (arr[mid] < arr[left] && arr[mid] < arr[right]) {
                right = mid;
            } else {
                return left + (isFirst ? 0: 1);
            }
            isFirst = false;
        }
        return left;
    }
    private static int getRandom(int min, int max) {
        return (int) (Math.random()*(max-min) + min);
    }
    public static void main(String[] args) {
        int[] arr = new int[20];
        int rotateAt = getRandom(0, 20);
        for(int i=0; i<20; i++) {
            int prevIndex = (i+rotateAt-1+20) % 20;
            int min = arr[prevIndex]+1;
            arr[(i+rotateAt+20) % 20] = getRandom(min, min+10);
        }
        System.out.println(Arrays.toString(arr) + ", Rotation at: " + rotateAt + " and computed rotation: " + findRotationIndex(arr) + " are equal: " + (findRotationIndex(arr) == rotateAt ? "Yes" : "No"));
    }
}
