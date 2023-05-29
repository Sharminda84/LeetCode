package graphs.dfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class DailyTempretureChecks {
    public static void main(String[] args) {
        int[] results = dailyTemperatures(new int []{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(results);
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int currDay = 0; currDay < n; currDay++) {
            int currentTemp = temperatures[currDay];
            // Pop until the current day's temperature is not
            // warmer than the temperature at the top of the stack
            while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {
                int prevDay = stack.pop();
                answer[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);
        }

        return answer;
    }
}
