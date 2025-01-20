import java.util.*;

class RatioFinder {
    Map<String, Map<String, Double>> givenRatio;
    public RatioFinder(String[] ratios) {
        this.givenRatio = new HashMap<>();
        for(String ratio: ratios) {
            String[] split = ratio.split("=");
            String[] names = split[0].split(":");
            String[] values = split[1].split(":");
            if(!givenRatio.containsKey(names[0])) {
                givenRatio.put(names[0], new HashMap<>());
            }
            if(!givenRatio.containsKey(names[1])) {
                givenRatio.put(names[1], new HashMap<>());
            }
            givenRatio.get(names[0]).put(names[1], Double.parseDouble(values[1])/Double.parseDouble(values[0]));
            givenRatio.get(names[1]).put(names[0], Double.parseDouble(values[0])/Double.parseDouble(values[1]));
        }
        Map<String, Double> relativeValue = new HashMap<>();
        Stack<String> stack = new Stack<>();
        Map.Entry<String, Map<String, Double>> first = givenRatio.entrySet().stream().findFirst().get();
        Set<String> set = new HashSet<>();
        stack.push(first.getKey());
        while(!stack.isEmpty()) {
            String key = stack.pop();
            set.add(key);
            if(!relativeValue.containsKey(key)) {
                relativeValue.put(key, 1.0);
            }
            double keyValue = relativeValue.get(key);
            Map<String, Double> relations = givenRatio.get(key);
            for(Map.Entry<String, Double> entry: relations.entrySet()) {
                relativeValue.put(entry.getKey(), entry.getValue()*keyValue);
                if(!set.contains(entry.getKey())) {
                    stack.push(entry.getKey());
                }
            }
        }
        System.out.println(relativeValue);
    }

    public static void main(String[] args) {
        String[] ratio = {"a:b=1:2", "b:c=1:3", "c:d=3:4", "d:e=1:2"};
        new RatioFinder(ratio);
    }
}
