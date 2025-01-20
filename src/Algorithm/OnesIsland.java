package Algorithm;

public class OnesIsland {
    public static void main(String[] args) {
        int [][]a = {
                {1, 1, 1},
                {1, 1, 0},
                {0, 0, 1}
        };
        new OnesIsland().maximalRectangle(a);
    }

    private int res = 0;
    public int maximalRectangle(int[][] A) {

        for(int i=0; i<A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                maxR(A, i, j);
            }
        }
        return 0;
    }

    private int maxR(int[][] A, int i, int j) {
        if(i>=A.length || j>=A[0].length || A[i][j] == 0) {
            return 0;
        }
        int subSize = maxR(A, i+1, j+1);

        int row1Count = 0;
        for(int c=i+1; c<A.length; c++) {
            if(A[i][c] == 0) {
                break;
            }
            row1Count++;
        }
        int col1Count = 0;
        for(int c=j+1; c<A[0].length; c++) {
            if(A[c][i] == 0) {
                break;
            }
            col1Count++;
        }

        A[i][j] = Math.min(subSize, Math.min(row1Count, col1Count)) + 1;
        res = Math.max(A[i][j], res);
        return A[i][j];
    }
}
