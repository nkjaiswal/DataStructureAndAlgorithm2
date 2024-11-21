import java.util.Stack;

class Node<T> {
    T data;
    Node<T> left;
    Node<T> right;
    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeIterator getTreeIterator() {
        return new BinaryTreeIterator(this);
    }

    public void print() {
        System.out.println(this.data.toString());
    }

    public String toString() {
        return this.data.toString();
    }
}

interface Iterator {
    public boolean hasNext();
    public Node next();
}

enum ToVisit {
    LEFT, ROOT, RIGHT, RETURN
}
class BinaryTreeIterator implements Iterator {
    private Stack<Node> nodes = new Stack();
    private Stack<ToVisit> toVisits = new Stack<>();

    public BinaryTreeIterator(Node node) {
        this.nodes.add(node);
        this.toVisits.add(ToVisit.LEFT);
    }

    public boolean hasNext() {
        return !this.nodes.empty();
    }

    public Node next() {
        Node currentNode = this.nodes.peek();
        if(this.toVisits.peek() == ToVisit.LEFT) {
            this.toVisits.pop();
            this.toVisits.push(ToVisit.ROOT);
            currentNode = currentNode.left;
            while(currentNode != null) {
                this.nodes.add(currentNode);
                this.toVisits.add(ToVisit.ROOT);
                currentNode = currentNode.left;
            }
        }
        if(this.toVisits.peek() == ToVisit.ROOT) {
            this.toVisits.pop();
            Node rootNode = this.nodes.peek();
            if(rootNode.right != null) {
                this.toVisits.push(ToVisit.RIGHT);
                return rootNode;
            } else {
                return this.nodes.pop();
            }
        } else {
            this.nodes.pop();
            this.toVisits.pop();
            this.nodes.push(currentNode.right);
            this.toVisits.push(ToVisit.LEFT);
            return next();
        }
    }
}

class BinaryTreeIteratorTest {
    public static void main(String[] args) {
        /**
         *          4
         *      2       6
         *     1 3     5 7
         */
        Node<Integer> node1 = new Node(1);
        Node<Integer> node3 = new Node(3);
        Node<Integer> node5 = new Node(5);
        Node<Integer> node7 = new Node(7);

        Node<Integer> node2 = new Node(2, node1, node3);
        Node<Integer> node6 = new Node(6, node5, node7);

        Node<Integer> node4 = new Node(4, node2, node6);

        BinaryTreeIterator it = node4.getTreeIterator();
        for(int i=0; it.hasNext(); i++) {
            it.next().print();
        }
    }
}