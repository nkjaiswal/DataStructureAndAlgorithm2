import java.util.*;

class IntervalNode {
    public int start, end;
    public IntervalNode(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
class MergeIntervals {
    List<IntervalNode> nodes;
    public MergeIntervals(int [][] intervals) {
        this.nodes = new ArrayList<>();
        for(int[] interval : intervals) {
            this.nodes.add(new IntervalNode(interval[0], interval[1]));
        }
        nodes.sort(Comparator.comparingInt(i -> i.start));
    }
    public List<IntervalNode> merge() {
        if(this.nodes.isEmpty()) {
            return Collections.emptyList();
        }
        List<IntervalNode> solution = new ArrayList<>();
        IntervalNode m = this.nodes.get(0);
        for(int i=1; i<this.nodes.size(); i++) {
            if(this.canOverlap(m, this.nodes.get(i))) {
                m = new IntervalNode(Math.min(m.start, this.nodes.get(i).start), Math.max(m.end, this.nodes.get(i).end));
            } else {
                solution.add(m);
                m = this.nodes.get(i);
            }
        }
        solution.add(m);
        return solution;
    }
    private boolean canOverlap(IntervalNode node1, IntervalNode node2) {
        return node1.start < node2.end && node2.start < node1.end;
    }
    public static void main(String[] args) {
        int [][] intervals = {};
        MergeIntervals mi = new MergeIntervals(intervals);
        mi.merge().forEach(i -> System.out.println(i.start + " " + i.end));
    }
}
