package queuestacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class MovingSum {

    int size,windowSum = 0, count = 0;

    Deque queue = new ArrayDeque<Integer>();

    public MovingSum(int size){
        this.size = size;
    }

    public double next(int val){
        ++count;

        queue.add(val);
        int tail = count >= size ? (int) queue.poll() :0;
        windowSum = windowSum - tail + val;
        return windowSum * 1.0 / Math.min(size, count);
    }
}
