package dsa.algorithms.dp;
import java.util.*;
public class CoinChangeCount {


    public static void main(String[] args) {
        long count = countWaysToMakeChange(new int[]{1,2,3,4,5,6,7,8,9,10},1000);
        System.out.println(count);
    }


        public static long countWaysToMakeChange(int denominations[], int value){
            //write your code here
            int n = denominations.length;

            long[][] dp = new long[n][value+1];
            for(int i = 0 ; i < n; i++){
                Arrays.fill(dp[i],-1);
            }
            long count = solve(denominations,0,value,n,dp);
            return count == -1 ? 0 : count;
        }



    static long solve(int[] denominations, int ind, int target, int n,long[][] dp ){
        if(target == 0) return 1;
        if(target < 0) return 0;
        if(ind == n) {
            return 0;
        }
        if(dp[ind][target] != -1) return dp[ind][target];
        //System.out.println("executed "+ind);
        long notPick = solve(denominations,ind+1,target,n,dp);
        long pick = 0 ;
        if(denominations[ind] <= target ){
            pick = solve(denominations,ind,target - denominations[ind],n,dp) ;
        }
        return dp[ind][target] = notPick + pick;
    }




}
