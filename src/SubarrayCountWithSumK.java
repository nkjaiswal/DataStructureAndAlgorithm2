import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SubarrayCountWithSumK {
    public static int find(int[ ] array, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int sum = 0;
        int found = 0;
        for(int num: array) {
            sum += num;
            if(sum == k) {
                found++;
            }
            found += countMap.getOrDefault(sum-k, 0);
            countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
        }
        return found;
    }

    public static void main(String[ ] args) {
        int[] array = {1, 2, 3};
        System.out.println(find(array, 3));
        System.out.println(find(array, 7));

        int[] arrayZeros = {0, 0, 1, 2, -3, 0};
        System.out.println(find(arrayZeros, 0));

        int[] array12121 = {1, 2, 1, 2, 1};
        System.out.println(find(array12121, 3));
    }
}
