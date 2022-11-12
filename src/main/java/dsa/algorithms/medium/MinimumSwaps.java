package dsa.algorithms.medium;

import java.util.ArrayList;

public class MinimumSwaps {
    public static int minimumSwaps(ArrayList<Integer> arr, int n, int k)
    {
        // Write your code here.

        int good = 0;
        int bad = 0;
        for(int no : arr){
            if(no <= k){
                good++;
            }

        }
        if(good ==0){
            return 0;
        }
        for(int i=0;i<good;++i)
            if(arr.get(i)>k)
                ++bad;

        int res = bad;
        for(int i = 0, j = good; j < n;j++,i++){
            if(arr.get(i) > k){
                bad--;
            }
            if(arr.get(j) > k){
                bad++;
            }
            res = Math.min(res,bad);
        }
        return res;
    }
}
