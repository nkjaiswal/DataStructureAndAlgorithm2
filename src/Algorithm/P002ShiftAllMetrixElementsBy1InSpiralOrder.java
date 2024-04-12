package Algorithm;

public class P002ShiftAllMetrixElementsBy1InSpiralOrder {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 16, 15, 14, 13},
                { 2, 17, 24, 23, 12},
                { 3, 18, 25, 22, 11},
                { 4, 19, 20, 21, 10},
                { 5, 6,   7,  8,  9},
        };
        print(arr);
        run(arr);
        print(arr);
    }

    static int currentValue;
    private static void run(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        Index currentIndex = new Index(0, 0, n, m);
        currentValue = arr[0][0];
        currentIndex.getSpiralIndexes((int x, int y ) -> {
            int nextValue = arr[x][y];
            arr[x][y] = currentValue;
            currentValue = nextValue;
        });
        arr[0][0] = currentValue;
    }

    interface ProcessIndex {
        void process(int x, int y);
    }
    private static class Index {
        public int x, y, n, m;
        public Index(int x, int y, int n, int m) {
            this.x = x;
            this.y = y;
            this.n = n;
            this.m = m;
        }

        public void getSpiralIndexes(ProcessIndex p) {
            int times = Math.min(n, m) / 2;
            boolean skip;
            for(int i=0; i<times; i++) {
                int x = i;
                int y = i;
                while(x < n-i) {
                    p.process(x, y);
                    x++;
                }
                skip = true;
                while(y < m-i) {
                    if(!skip)
                        p.process(x-1, y);
                    skip = false;
                    y++;
                }
                skip = true;
                while(x > i) {
                    if(!skip)
                        p.process(x-1, y-1);
                    skip = false;
                    x--;
                }
                skip = true;
                while(y > i) {
                    if(!skip && y > i+1)
                        p.process(x, y-1);
                    skip = false;
                    y--;
                }
            }
            if(m < n) {
                for(int j=0; j<n - 2*times; j++) {
                    p.process(j+times, times);
                }
            } else if(n < m) {
                for(int j=0; j<m - (2*times); j++) {
                    p.process(times, j+times);
                }
            } else if (n%2 == 1) {
                p.process(n/2, n/2);
            }
        }
    }


    private static void print(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        for (int[] ints : arr) {
            for (int j = 0; j < m; j++) {
                System.out.print(ints[j] + "\t");
            }
            System.out.println();
        }
    }
}
