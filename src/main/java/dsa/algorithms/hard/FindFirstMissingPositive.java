package dsa.algorithms.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindFirstMissingPositive {
    public static void main(String[] args) {
        int[] nums= {-1,4,2,1,9,10} ;
        System.out.println(firstMissingPositive1(nums));
    }

    static public int firstMissingPositive1(int[] nums) {

        int n = nums.length;
        for(int i=0; i < n;i++){
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i]-1]){
                System.out.println("i "+i+" nums[i] "+nums[i]);
              /*  int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[nums[i]-1] = temp;*/


                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));

        for(int i=0; i < n;i++){
            if(i + 1 != nums[i]){
                return i+1;
            }
        }
        return n+1;
    }

    public int firstMissingPositive(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet(nums.length);
        for(int i = 0 ; i < nums.length; i++){
            int v = nums[i];
            if(v >0 && v < min){
                min = v;
            }
            max = Math.max(max,v);
            if(v > 0) set.add(v);
        }
        if(max <= 0 || min == Integer.MIN_VALUE || min > 1){
            return 1;
        }

        for(int i = min + 1; i <= max;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return max + 1;



    }
}
