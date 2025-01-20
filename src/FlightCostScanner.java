import java.util.HashMap;
import java.util.Map;

class FlightCostScanner {
    Map<Integer, Map<Integer, Integer>> costs= new HashMap<>();
    final int[] cityCost;
    final int cityCount;
    public FlightCostScanner(int[][] costs, int cityCount) {
        for(int[] cost: costs) {
            int from  = cost[0];
            int to  = cost[1];
            int flightCost  = cost[2];
            if(!this.costs.containsKey(from)) {
                this.costs.put(from, new HashMap<>());
            }
            this.costs.get(from).put(to, flightCost);
        }
        this.cityCount = cityCount;
        this.cityCost = new int[cityCount];
        for(int i=0; i<cityCount; i++) {
            this.cityCost[i] = 9999;
        }
    }
    public int minCost(int maxHops, int source, int dest) {
        this.minimumCost(maxHops, source, dest, 0);
        return this.cityCost[dest];
    }
    private void minimumCost(int maxHops, int source, int dest, int costTillNow) {
        if(source == dest) {
            this.cityCost[dest] = Math.min(this.cityCost[dest], costTillNow);
            return;
        }
        if(maxHops <= 0) {
            return;
        }
        Map<Integer, Integer> sourceFareChart = this.costs.get(source);
        for(Map.Entry<Integer, Integer> e : sourceFareChart.entrySet()) {
            this.minimumCost(maxHops-1, e.getKey(), dest, costTillNow + e.getValue());
        }

    }
    public static void main(String[] args) {
        int[][] fareChar1 = {{0, 1, 100}, {1, 2, 100}, {2, 3, 100}, {0, 2, 500}};
        System.out.println(new FlightCostScanner(fareChar1, 4).minCost(2, 0, 3));
    }
}
