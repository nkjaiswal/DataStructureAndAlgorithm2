package Algorithm;

public class RotateSquareMatrixInplace {
    public static void main(String[] args) {
        int [][]matrixEven = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int [][]oddEven = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        print(matrixEven, 4);
        rotate(matrixEven, 4);
        print(matrixEven, 4);
    }

    private static void rotate(int [][] matrix, int n) {
        System.out.println();
        for(int i=0; i<n; i++) {
//            int rotationDim = n
            for(int j=i; j<n-i-1; j++) {


            }
        }
    }

    private static void print(int [][] matrix, int n) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
