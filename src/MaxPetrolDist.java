import java.util.*;

class MaxPetrolDist {
    private final List<Integer> pumpPositions;
    public MaxPetrolDist(List<Integer> pumpPositions) {
        this.pumpPositions = pumpPositions;
    }
    public double minMaxDistance(int newPumpCount) {
        int currentPumpCount = this.pumpPositions.size();
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double gapSum = 0;
        for(int i=0; i<currentPumpCount-1; i++) {
            gapSum += this.pumpPositions.get(i+1) - this.pumpPositions.get(i);
        }
        int leftPumps = newPumpCount;
        for(int i=0; i<currentPumpCount-1; i++) {
            double gap = this.pumpPositions.get(i+1) - this.pumpPositions.get(i);
            int hereNewPumpCount = (int)(newPumpCount * gap / gapSum);
            leftPumps -= hereNewPumpCount;
            if(hereNewPumpCount > 0) {
                double gapsHere = gap / (1+hereNewPumpCount);
                for(int j=0; j<=hereNewPumpCount; j++) {
                    maxHeap.add(gapsHere);
                }
            } else {
                maxHeap.add(gap);
            }
        }
        for(int i=0; i<leftPumps; i++) {
            double currentGap = maxHeap.remove();
            maxHeap.add(currentGap/2);
            maxHeap.add(currentGap/2);
        }
        double maxGap = 0;
        while(!maxHeap.isEmpty()) {
            maxGap = Math.max(maxGap, maxHeap.remove());
        }
        return maxGap;

    }
    public static void main(String[] args) {
        System.out.println(new MaxPetrolDist(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)).minMaxDistance(9));
        System.out.println(new MaxPetrolDist(Arrays.asList(3,6,12,19,33,44,67,72,89,95)).minMaxDistance(2));
    }
}
