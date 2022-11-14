package dsa.algorithms.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            public int compare(Integer i1,Integer i2){
                return i2 - i1;
            }
        });

        for(int n : nums){
            pq.offer(n);
        }
        int res = 0;
        for(int i = 1; !pq.isEmpty() && i <= k;i++){
            res = pq.poll();
        }
        return res;

    }
}
