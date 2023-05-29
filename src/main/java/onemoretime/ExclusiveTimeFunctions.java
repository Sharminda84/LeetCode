package onemoretime;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ExclusiveTimeFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Log> stack = new ArrayDeque<>();
        int[] result = new int[n];
        for(String s : logs){
            Log log = new Log(s);
            if (log.is_start){
                stack.push(log);
            }
            else {
               Log top = stack.pop();
               result[top.id] += (log.time - top.time)
                                 + 1 // time on process
                                  - top.sub_duration;
               // next item's sub duration needs to be updated.
                if(!stack.isEmpty()){

                    stack.peek().sub_duration += (log.time - top.time) + 1;
                }
            }
        }
        return result;
    }

    public static class Log {
        public int id;
        public boolean is_start;
        public int time;
        public int sub_duration;

        public Log(String s){
            String[] cols = s.split(":");

            this.id = Integer.valueOf(cols[0]);
            this.is_start = cols[1].equalsIgnoreCase("start")? true: false;
            this.time = Integer.valueOf(cols[2]);
            this.sub_duration = 0;
        }
    }
}
