package dsa.algorithms.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountDistinctElementsWithReversed {

    public static void main(String[] args) {
        int nums[] = {1,13,10,12,31};
       int res =  countDistinctIntegers(nums);
        System.out.println(res);
    }
    public static int countDistinctIntegers(int[] nums) {


        int revCount = 0;
        Set<Integer> set = new HashSet();

        for(int n : nums){
            set.add(n);
        }
        int count  = set.size();
        for(int n : nums){

            if(!reverse(n,set)){
                count++;
            }


        }
        // System.out.println("revCount "+revCount);
        return count;
    }

    static boolean reverse(int x, Set<Integer> set){
        int revNo = 0;
        while ( x != 0){
            int rem = x % 10;
            revNo = (revNo * 10 + rem);
            x /= 10;
        }
        return set.contains(revNo);
    }


    public int countDistinctIntegersUsingSet    (int[] nums) {
        Integer.parseInt("1");

        Set<Integer> set = new HashSet(nums.length * 2);

        for(int n : nums){
            set.add(n);
        }
        Set<Integer> another = new HashSet(set);
        for(int n : another){
            set.add(reverseNum(n,set));
        }
        return set.size();
    }


    int reverseNum(int x,Set<Integer> set){
        int revNo = 0;
        while ( x != 0){
            int rem = x % 10;
            revNo = (revNo * 10 + rem);
            x /= 10;
        }
        return revNo;
    }
}
