package queuestacks;

import java.util.LinkedList;
import java.util.Queue;

public class Trials {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        System.out.println(queue);System.out.println(queue.peek());
        queue.offer(2);
        queue.add(3);
        queue.offer(4);
        queue.poll();
        queue.remove();
        System.out.println(queue);System.out.println(queue.peek());
//        queue.poll();
//        System.out.println(queue);System.out.println(queue.peek());


    }
}
