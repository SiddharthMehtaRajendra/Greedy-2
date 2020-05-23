//Time Complexity: O(n)
//Space Complexity: O(1)

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0; int maxCount = 0;
        for(int i = 0; i < tasks.length; i++){
            if(!map.containsKey(tasks[i])){
                map.put(tasks[i], 0);
            }
            int count = map.get(tasks[i]) + 1;
            map.put(tasks[i], count);
            maxFreq = Math.max(maxFreq, count);
        }
        
        for(int value : map.values()){
            if(value == maxFreq) maxCount++;
        }
        
        int partition = maxFreq - 1;
        int empty = (n - (maxCount - 1)) * partition;
        int pending = tasks.length - (maxCount * maxFreq);
        int idle = Math.max(0, (empty - pending));
        
        return tasks.length + idle;
    }
}
