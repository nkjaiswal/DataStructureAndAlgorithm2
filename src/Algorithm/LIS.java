package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LIS {
    public static void main(String[] args) {
//        int[] n = { 100, 3, 6, 3, 4, 5 };
//        System.out.println(new LIS().lis(n));
        List<Integer> test = new ArrayList<>();

        test.add(0);
        test.add(1);
        test.add(2);
        System.out.println(test);
        test.remove(0);
        System.out.println(test);
        System.out.println(test.get(0));
        try {
            Runtime.getRuntime().exec("cls/clear");
        } catch (Exception exception) {}

        System.out.println(-1%5);
    }
    private final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int lis(final int[] A) {
        int max = 0;
        for(int i=0; i<A.length; i++) {
            max = Math.max(max, lisI(A, i));
        }
        return max;
    }

    private int lisI(final int[] A, int i) {
        if(i >= A.length) {
            return 0;
        }
        if(map.containsKey(i)) {
            return map.get(i);
        }
        int max = 1;
        for(int c = i+1; c<A.length; c++) {
            if(A[c] > A[i]) {
                max = Math.max(max, 1 + lisI(A, c));
            }
        }
        map.put(i, max);
        return max;
    }
}
