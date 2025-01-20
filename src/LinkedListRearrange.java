class LinkedListNode {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[41m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    int data;
    LinkedListNode next;
    public LinkedListNode(int data, LinkedListNode next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return this.data + " -> " + (this.next !=null ? this.next.toString() : (ANSI_RED + "null" + ANSI_RESET));
    }
}
public class LinkedListRearrange {

    public static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode current = head;
        LinkedListNode next = head.next;
        LinkedListNode last = next.next;
        current.next = null;
        while(next != null) {
            next.next = current;
            current = next;
            next = last;
            last = last != null ? last.next : null;
        }
        return current;
    }

    public static LinkedListNode getMid(LinkedListNode head) {
        LinkedListNode slowPointer = head;
        LinkedListNode fastPointer = head.next;
        while (fastPointer !=null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    public static void main(String[] args) {
        LinkedListNode node7 = new LinkedListNode(7, null);
        LinkedListNode node6 = new LinkedListNode(6, node7);
        LinkedListNode node5 = new LinkedListNode(5, node6);
        LinkedListNode node4 = new LinkedListNode(4, node5);
        LinkedListNode node3 = new LinkedListNode(3, node4);
        LinkedListNode node2 = new LinkedListNode(2, node3);
        LinkedListNode node1 = new LinkedListNode(1, node2);
        System.out.println(node1);
        LinkedListNode mid = getMid(node1);
        System.out.println(mid);
        mid.next = reverse(mid.next);
        System.out.println(node1);

    }
}
