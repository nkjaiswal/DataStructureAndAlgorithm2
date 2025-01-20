import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class DeQueue {
    List<Integer> queue = new ArrayList<>();
    public int peekFront() {
        return queue.get(queue.size() - 1);
    }
    public int peekBack() {
        return queue.get(0);
    }
    public void addToFront(int item) {
        queue.add(item);
    }
    public void removeFromFront() {
        queue.remove(queue.size()-1);
    }
    public void removeFromBack() {
        queue.remove(0);
    }
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    public int size() {
        return queue.size();
    }
}

class MaxInSlidingWindow {
    public static List<Integer> maxItems(int[] items, int k) {
        List<Integer> sol = new ArrayList<>();
        DeQueue queue = new DeQueue();
        int length = items.length;
        int right = 0;
        int left = 0;
        while(right<length) {
            while(!queue.isEmpty() && items[right] > queue.peekFront()) {
                queue.removeFromFront();
            }
            queue.addToFront(items[right]);
            if(right - left == k-1) {
                sol.add(queue.peekBack());
            }
            if(right - left == k) {
                int removedItem = items[left];
                sol.add(queue.peekBack());
                if(queue.peekBack() == removedItem) {
                    queue.removeFromBack();
                }
                left++;
            }

            right++;

        }
        return sol;
    }

    public static void main(String[] args) {
        int[] data = {1,3,-1,-3,5,3,6,7};
        System.out.println(maxItems(data, 3));
    }
}
