import java.util.Collections;
import java.util.PriorityQueue;

class StreamMedian {
    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private double median;
    public void add(int number) {
        if(number < median) {
            this.maxHeap.add(number);
            if(this.maxHeap.size() - this.minHeap.size() == 2) {
                this.minHeap.add(this.maxHeap.poll());
            }
        } else {
            this.minHeap.add(number);
            if(this.minHeap.size() - this.maxHeap.size() == 2) {
                this.maxHeap.add(this.minHeap.poll());
            }

        }
        if(this.maxHeap.size() - this.minHeap.size() != 0) {
            median = this.maxHeap.size() > this.minHeap.size() ? this.maxHeap.peek() : this.minHeap.peek();
        } else {
            median = (this.maxHeap.peek() + this.minHeap.peek())/2.0;
        }
    }
    public double getMedian() {
        return this.median;
    }

    public static void main(String[] args) {
        StreamMedian sm = new StreamMedian();
        sm.add(10);
        System.out.println(sm.getMedian()); // 10
        sm.add(2);
        System.out.println(sm.getMedian()); // 6
        sm.add(2);
        System.out.println(sm.getMedian()); // 2
        sm.add(12);
        System.out.println(sm.getMedian()); // 6
    }
}
