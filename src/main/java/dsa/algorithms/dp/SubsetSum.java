package dsa.algorithms.dp;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

    static boolean isExists(int[] values, int sum,int currentItem){
        List<Integer> list = new ArrayList<>();
        if(sum == 0 ){
            System.out.println("sum: "+sum + " indices "+list);
            return true;
        }
        if(currentItem == 0){
            return false;
        }
        if(values[currentItem - 1] > sum){
            return isExists(values,sum,currentItem - 1);
        }
        boolean include = isExists(values,sum - values[currentItem - 1], currentItem - 1);
        if(include){
            list.add(currentItem - 1);
        }
        return include ||
                isExists(values,sum,currentItem - 1);
    }

    static boolean isExists(int[] values, int sum){
        int len = values.length;
        boolean[][] dp = new boolean[len+1][sum+1];
        dp[0][0] = true;
        for(int i = 1; i <= sum;i++){
            dp[0][i] = false;
        }
        for(int i = 1; i <= len;i++){
            dp[i][0] = true;
        }

        for(int i = 1; i <= len; i++){
            for(int j = 1; j <= sum ; j++){
                dp[i][j] = dp[i - 1][j];
                if(values[i-1] <= j){
                    dp[i][j] = dp[i][j] || dp[i -1][j-values[i -1]];
                }
                //System.out.println("value "+(j-values[i -1]));

            }
        }
        return dp[len][sum];
    }

    static boolean isExistsV1(int[] values, int sum){

        boolean[] dp = new boolean[sum + 1];

        dp[0] = true;

        int len = values.length;

        for(int i = 0 ; i < len; i++){
            for(int j = sum; j >= values[i]; j--){
                if(dp[j - values[i]]){
                    dp[j] = true;
                }
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        int[] values = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        boolean res = isExists(values,sum, values.length);
        System.out.println(res);
        System.out.println("using dp "+ isExists(values,sum));
        System.out.println("using dp v1: "+ isExistsV1(values,sum));
        values = new int[]{1, 8, 2, 5};
        sum = 4;
        res = isExists(values,sum, values.length);
        System.out.println(res);
        System.out.println("using dp "+ isExists(values,sum));
        System.out.println("using dp v1: "+ isExistsV1(values,sum));
        values = new int[]{ 1, 3, 11 , 5 };
        sum = 9;
        System.out.println("using dp "+ isExists(values,sum));
        System.out.println("using dp v1: "+ isExistsV1(values,sum));
    }
}
