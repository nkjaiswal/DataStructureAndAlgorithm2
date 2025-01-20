import java.util.ArrayList;
import java.util.List;

public class TaskSchedularWithCooldown {
    private int ctoi(char c) {
        return c - 65;
    }
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int totalTask = tasks.length;
        int maxFreq = 0;
        for(char c : tasks) {
            int task = this.ctoi(c);
            freq[task]++;
            maxFreq = Math.max(maxFreq, freq[task]);
        }
        int noOfItemsWithMaxFreq = 0;
        for(int i=0; i<26; i++) {
            if(freq[i] == maxFreq) {
                noOfItemsWithMaxFreq ++;
            }
        }
        int currentDuration = maxFreq + (maxFreq-1)*n + noOfItemsWithMaxFreq -1;
        int majorSlots = maxFreq - 1;
        int minorSlots = majorSlots * (n - noOfItemsWithMaxFreq + 1);

        int pendingTaskToSchedule = totalTask - (maxFreq * noOfItemsWithMaxFreq);
        if(pendingTaskToSchedule <= minorSlots) {
            return currentDuration;
        }
        return currentDuration + (pendingTaskToSchedule - minorSlots);
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'B', 'C', 'D', 'A', 'B', 'C', 'D', 'A', 'B', 'C', 'D', 'A', 'B', 'C', 'D', 'E', 'F'};
        System.out.println(new TaskSchedularWithCooldown().leastInterval(tasks, 4));
    }
}
