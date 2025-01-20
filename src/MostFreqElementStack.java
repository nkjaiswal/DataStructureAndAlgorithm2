import java.util.*;

class StackElement implements Comparable<StackElement> {
    int data;
    int freq;
    List<Integer> top;
    public StackElement(int data, int freq, int top) {
        this.data = data;
        this.freq = freq;
        this.top = new ArrayList<>();
        this.top.add(top);
    }

    @Override
    public int compareTo(StackElement otherElement) {
        if(this.freq == otherElement.freq) {
            return this.top.get(this.top.size()-1) - otherElement.top.get(otherElement.top.size()-1);
        }
        return this.freq - otherElement.freq;
    }

    public void pushed(int top) {
        this.freq++;
        this.top.add(top);
    }

    public void pop() {
        this.freq--;
        this.top.remove(this.top.size()-1);
    }
}
public class MostFreqElementStack {
    PriorityQueue<StackElement> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    Map<Integer, StackElement> lookup = new HashMap<>();
    public void push(int n) {
        if(!lookup.containsKey(n)) {
            StackElement element = new StackElement(n, 0, 0);
            lookup.put(n, element);
            maxHeap.add(element);
        }
        StackElement element = lookup.get(n);
        maxHeap.remove(element);
        element.pushed(maxHeap.size());
        maxHeap.add(element);
    }

    public int pop() {
        if(maxHeap.isEmpty()) {
            return -1;
        }
        StackElement element = maxHeap.remove();
        if(element.freq == 1) {
            lookup.remove(element.data);
            return element.data;
        }
        element.pop();
        maxHeap.add(element);
        return element.data;
    }

    public static void main(String[] args) {
        MostFreqElementStack freqStack = new MostFreqElementStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);

        System.out.println(freqStack.pop()); // 5
        System.out.println(freqStack.pop()); // 7
        System.out.println(freqStack.pop()); // 5
        System.out.println(freqStack.pop()); // 4
    }
}
