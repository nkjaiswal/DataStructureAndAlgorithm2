import java.util.*;

enum Marker {
    START, END
}
class Node {
    public Marker marker;
    public int xCoord;
    public int height;
    public Node(Marker marker, int xCoord, int height) {
        this.marker = marker;
        this.xCoord = xCoord;
        this.height = height;
    }
}
class SkylineScanner {
    private final int[][] buildingHeights;
    private final PriorityQueue<Integer> maxHeap;
    public SkylineScanner(int[][] buildingHeights) {
        this.buildingHeights = buildingHeights;
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    public int[][] scan() {
        int[][] scanResult = new int[100][2];
        List<Node> nodes = new ArrayList<>();
        for(int[] buildingHeight: this.buildingHeights) {
            Node nodeStart = new Node(Marker.START, buildingHeight[0], buildingHeight[2]);
            Node nodeEnd = new Node(Marker.END, buildingHeight[1], buildingHeight[2]);
            nodes.add(nodeStart);
            nodes.add(nodeEnd);
        }
        nodes.sort(Comparator.comparingInt(n -> n.xCoord));
        int currentMaxHeapTop = 0;
        int scanResultCounter = 0;
        for(Node node: nodes) {
            if(node.marker == Marker.START) {
                this.maxHeap.add(node.height);
            } else {
                this.maxHeap.remove(node.height);
            }
            if(!this.maxHeap.isEmpty() && this.maxHeap.peek() != currentMaxHeapTop) {
                scanResult[scanResultCounter][0] = node.xCoord;
                scanResult[scanResultCounter][1] = this.maxHeap.peek();
                currentMaxHeapTop = this.maxHeap.peek();
                scanResultCounter++;
            } else if(this.maxHeap.isEmpty()) {
                scanResult[scanResultCounter][0] = node.xCoord;
                scanResult[scanResultCounter][1] = 0;
                currentMaxHeapTop = 0;
                scanResultCounter++;
            }
        }
        return scanResult;
    }
    public static void main(String[] args) {
        int[][] buildingHeights = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        SkylineScanner scanner = new SkylineScanner(buildingHeights);
        int[][] scanResult = scanner.scan();
        for(int[] result: scanResult) {
            System.out.println(result[0] + " : " + result[1]);
        }
    }
}
