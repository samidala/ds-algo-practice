package dsa.algorithms.hard;

import java.util.ArrayList;
import java.util.List;

public class NextPermutationSequenceInLexOrder {

    public static void main(String[] args) {
        int n = 4;
        int k = 9;
        System.out.println(nextPermutation(n,k));
    }

    static String nextPermutation(int n, int k){
        int fact = 1;
        List<Integer> nums = new ArrayList<>(n);
        for(int i = 1; i < n; i++){
            fact*=i;
            nums.add(i);
        }
        nums.add(n);
        k = k - 1;
        StringBuilder ans = new StringBuilder();
        while (!nums.isEmpty()){
            int index = k / fact;
            ans.append(nums.get(index));
            nums.remove(index);
            k = k % fact;
            if(!nums.isEmpty()){
                fact = fact /nums.size();
            }

        }
        return ans.toString();

    }
}
