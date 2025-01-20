import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class MergeKSortedLinkedList {
    public static LinkedList<Integer> merge(LinkedList<Integer>[ ] sortedLists) {
        PriorityQueue<Integer[ ]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int nonEmptyListCount = 0;
        int index = 0;
        LinkedList<Integer> solution = new LinkedList<>();
        for(LinkedList<Integer> list: sortedLists) {
            if(list.isEmpty()) {
                continue;
            }
            Integer[] data = {list.poll(), index++};
            minHeap.add(data);
            nonEmptyListCount ++;
        }
        while(nonEmptyListCount > 0) {
            Integer[] data = minHeap.poll();
            solution.add(data[0]);
            if(sortedLists[data[1]].isEmpty()) {
                nonEmptyListCount--;
                continue;
            }
            Integer[] newData = {sortedLists[data[1]].poll(), data[1]};
            minHeap.add(newData);
		}
            return solution;
        }
        public static void main(String [ ] args) {
            LinkedList<Integer> ll1 = new LinkedList<>(List.of(1,4,5));
            LinkedList<Integer> ll2 = new LinkedList<>(List.of(1,3,4));
            LinkedList<Integer> ll3 = new LinkedList<>(List.of(2,6));
            LinkedList<Integer> ll4 = new LinkedList<>(List.of());
            LinkedList<Integer>[] lists = new LinkedList[4];
            lists[0] = ll1;
            lists[1] = ll2;
            lists[2] = ll3;
            lists[3] = ll4;
            System.out.println(merge(lists));
        }
    }
