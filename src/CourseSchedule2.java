import java.util.*;

class CourseSchedule2 {
    public static List<Integer> solve(int[][] dependencies) {
        List<Integer> reads = new ArrayList<>();
        Map<Integer, Set<Integer>> prereq = new HashMap<>();
        Map<Integer, Integer> prereqCount = new HashMap<>();
        for(int[] dependency: dependencies) {
            int before = dependency[1];
            int after = dependency[0];
            if(!prereq.containsKey(before)) {
                prereq.put(before, new HashSet<>());
            }
            prereq.get(before).add(after);
            if(!prereqCount.containsKey(after)) {
                prereqCount.put(after, 0);
            }
            if(!prereqCount.containsKey(before)) {
                prereqCount.put(before, 0);
            }
            prereqCount.put(after, prereqCount.get(after)+1);
        }
        Stack<Integer> stack = new Stack<>();
        for(Map.Entry<Integer, Integer> e: prereqCount.entrySet()) {
            if(e.getValue() == 0) {
                stack.push(e.getKey());
            }
        }
        while(!stack.isEmpty()) {
            int finishCourse = stack.pop();
            reads.add(finishCourse);
            Set<Integer> afterReads = prereq.get(finishCourse);
            if(afterReads == null) {
                continue;
            }
            for(Integer afterRead: afterReads) {
                int pendingCount = prereqCount.get(afterRead) - 1;
                prereqCount.put(afterRead, pendingCount);
                if(pendingCount == 0) {
                    stack.push(afterRead);
                }
            }
        }
        return reads;
    }

    public static void main(String[] args) {
        int[][] prereq = {{1, 0}, {0, 1}};
        System.out.println(solve(prereq));
    }
}
