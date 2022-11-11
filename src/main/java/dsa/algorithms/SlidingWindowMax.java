package dsa.algorithms;

import java.util.Deque;
import java.util.LinkedList;

class SlidingWindowMax {
    public static void main(String[] args) {

    }
    public static int[] maxSlidingWindow(int[] nums, int k) {

        if(k == 1){
            return nums;
        }

        Deque<Integer> dq = new LinkedList();

        int len = nums.length;
        int[] res = new int[len - k + 1];
        for(int i = 0 ; i < len; i++){

            if(!dq.isEmpty() && dq.peek() < i - k + 1){
                //   System.out.println(" dq.peek() "+ dq.peek());
                dq.poll();
            }

            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                //    System.out.println(" dq.peekLast() "+ dq.peekLast());
                dq.pollLast();
            }
            dq.offer(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[dq.peek()];
            }
        }

        return res;
    }
}