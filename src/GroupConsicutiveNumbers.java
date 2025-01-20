import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class GroupConsicutiveNumbers {
    public int[][] group(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n: nums){
            if(!freq.containsKey(n)) {
                freq.put(n, 0);
            }
            freq.put(n, freq.get(n) + 1);
        }
        while(!freq.isEmpty()) {
            Optional<Map.Entry<Integer, Integer>> entry = freq.entrySet().stream().findFirst();
            boolean more = true;
            int currentPointer = entry.get().getKey();
            while(more) {
                int startWith = currentPointer;
                more = false;
                while(freq.containsKey(startWith)) {
                    more = true;
                    int count = freq.get(startWith);
                    if(count == 1) {
                        freq.remove(startWith);
                    } else {
                        freq.put(startWith, count-1);
                    }
                    startWith --;
                }
                // remove 5*n entry
                currentPointer = 1 + startWith + ((int)(entry.get().getKey() -startWith)/5)*5;
            }
            more = true;
            while(more) {
                int startWith = currentPointer;
                more = false;
                while(freq.containsKey(startWith)) {
                    more = true;
                    int count = freq.get(startWith);
                    if(count == 1) {
                        freq.remove(startWith);
                    } else {
                        freq.put(startWith, count-1);
                    }
                    startWith ++;
                }
                // remove 5*n entry
//                int totalItems = (startWith-1)
                currentPointer = startWith - ((int)(startWith-1)/5)*5 + entry.get().getKey() -1;
            }

        }
        int[][] x = new int[10][10];
        return x;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,2,3,4,5,6,7,8,9,10,11,12,13};
        new GroupConsicutiveNumbers().group(nums);
    }
}
