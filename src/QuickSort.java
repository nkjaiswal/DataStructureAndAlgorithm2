import java.util.Arrays;

public class QuickSort {
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static int partician(int[] arr, int left, int right) {
        int pivot = arr[right];
        int smallPointer = left - 1;
        for(int j=left; j<right; j++) {
            if(arr[j] < pivot) {
                smallPointer++;
                swap(arr, smallPointer, j);
            }
        }
        swap(arr, smallPointer+1, right);
        return smallPointer+1;
    }
//    public static int[] sort(int[] arr) {
//
//    }
    public static void main(String[] args) {
        int[] arr = {4,6,2,6,8,3,1,4,67,9,4,3,5};
        System.out.println(partician(arr, 0, arr.length-1));
        System.out.println(Arrays.toString(arr));
    }
}
