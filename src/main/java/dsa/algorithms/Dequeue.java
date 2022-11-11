package dsa.algorithms;

import java.util.Deque;
import java.util.LinkedList;

public class Dequeue {
    public static void main(String[] args) {

        Deque<Integer> dq;
        dq = new LinkedList<>();
        dq.offer(1);
        dq.offer(2);
        System.out.println(dq.peekLast());
       /* dq.offer(2);
        System.out.println(dq.peek() == dq.peekFirst());*/
    }
}
