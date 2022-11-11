package dsa.algorithms.medium;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][2];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int count = 1;
        int j = 0;
        res[j] = intervals[0];
        for(int i = 0; i < intervals.length;i++){
            if(res[j][1] >= intervals[i][0]){
                res[j] = new int[]{res[j][0],Math.max(intervals[i][1],res[j][1])};
            }else{
                res[++j] = intervals[i];
                count++;
            }


        }


        int[][] res1 = new int[count][2];
        int i = 0;
        while (count > 0){
            res1[i] = res[i];
            count--;
            i++;
        }

        return res1;
    }
}
