import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MeetingRoomFinder2 {
    public static int minimumRoom(int[][] intervals) {
        List<Integer> events = new ArrayList<>();
        for(int[] interval: intervals) {
            events.add(interval[0]);
            events.add(-interval[1]);
        }
        events.sort(Comparator.comparingInt(Math::abs));
        int min = 0;
        int ongoing = 0;
        for(Integer event: events) {
            if(event >= 0) {
                if(ongoing >= min) {
                    min++;
                    ongoing++;
                }
            } else {
                ongoing--;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int [][] intv1 = {{7, 10}, {2, 4}, {15, 20}};
        System.out.println(minimumRoom(intv1));
    }
}
