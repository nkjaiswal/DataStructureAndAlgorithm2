import java.util.Comparator;
import java.util.PriorityQueue;

public class KthMinInSorted2DArray {

    public static int find(int[][] array, int k) {
        // [data, row, col]
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>(Comparator.comparingInt((Integer[] a) -> a[0]));
        int rows = array.length;
        int cols = array[0].length;
        for(int i=0; i<rows; i++) {
            Integer[] data = {array[i][0], i, 0};
            minHeap.add(data);
        }

        for(int i=0; i<k-1; i++) {
            Integer[] data = minHeap.poll();
            int row = data[1];
            int col = data[2];
            if(col+1 == cols) {
                continue;
            }
            Integer[] newData = {array[row][col+1], row, col+1};
            minHeap.add(newData);
        }

        return minHeap.peek()[0];
    }
    public static void main(String[] args) {
        int[][] array = {
                {1,  2,  3,   4,    5     ,6},
                {11, 20, 200, 2000, 20000, 20001},
                {12, 30, 300, 3000, 30000, 30001},
                {13, 40, 400, 4000, 40000, 40001},
                {14, 50, 500, 5000, 50000, 50001},
        };
        System.out.println(find(array, 26));
    }
}
