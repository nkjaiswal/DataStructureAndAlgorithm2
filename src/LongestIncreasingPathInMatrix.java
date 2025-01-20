import java.util.Arrays;

class LongestIncreasingPathInMatrix {

    private static boolean isValidCell(int i, int j, int rows, int cols) {
        if(i<0 || j<0 || i>=rows || j>=cols) {
            return false;
        }
        return true;
    }
    public static int find(int[][] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int rows = array.length;
        int cols = array[0].length;

        int[][] direction = {
                { -1, 0},
                {0, -1},
                {1, 0},
                {0, 1}
        };
        int[][] currentCost = new int[rows][cols];
        for(int i=0; i<rows; i++)
            for(int j=0; j<cols; j++)
                currentCost[i][j]=1;
        int max = 0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                for(int k=0; k<direction.length; k++) {
                    int ni = i+direction[k][0];
                    int nj = j+direction[k][1];
                    if(isValidCell(ni, nj, rows, cols) && array[ni][nj]>array[i][j]) {
                        currentCost[ni][nj] = Math.max(currentCost[ni][nj], currentCost[i][j]+1);
                        max = Math.max(max, currentCost[ni][nj]);
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(currentCost));
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        System.out.println(find(matrix));
    }
}
