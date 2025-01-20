import java.util.*;

public class SlidingWindowMaxElement {
    public static List<Integer> slide(int[] nums, int k) {
        List<Integer> maxElements = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        int left = 0;
        int right = 0;
        for(int num: nums) {
            while(!queue.isEmpty() && num > queue.peekLast()) {
                queue.removeLast();
            }
            queue.add(num);
            right++;
            if(right - left > k && queue.peekFirst() == nums[left]) {
                queue.removeFirst();
                left++;
            }
            maxElements.add(queue.peekFirst());
        }
        return maxElements;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(slide(nums, k)); // Output: [3, 3, 5, 5, 6, 7]
    }
}
