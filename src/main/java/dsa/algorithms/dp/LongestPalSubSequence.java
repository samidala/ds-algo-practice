package dsa.algorithms.dp;

import java.util.Arrays;

public class LongestPalSubSequence {
    public static void main(String[] args) {
        String str = "GEEKSFORGEEKS";
        int res = longestPalSubSeq(str,0, str.length() - 1);
        System.out.println(res);
        res = longestPalSubSeq(str);
        System.out.println(res);
    }

    //static int longestPalSubSeq(String str
    static int longestPalSubSeq(String str, int i, int j){


        if(i == j ){
            return 1;
        }
        boolean isSame = str.charAt(i) == str.charAt(j);
        if (isSame && i + 1 == j) {
            return 2;
        }

        if(isSame){
            return 2 + longestPalSubSeq(str,i+1, j -1);
        }
        return Math.max(
                longestPalSubSeq(str, i,j - 1),
                longestPalSubSeq(str,i+1, j )
        );
    }

    static int longestPalSubSeq(String str){
        int len = str.length();
        int[][] dp = new int[len+1][len+1];
        for(int i = 0 ; i < len; i++){
            dp[i][i] = 1;
        }

        for(int i = 0; i <=len; i++){
            for (int j = len  ; j >= 0; j--){
                if(i == j){
                    continue;
                }

                if(i == 0 || j == 0){
                    continue;
                }
                boolean areSame = str.charAt(i - 1) == str.charAt(j - 1);
                if(areSame && i + 1 == j ){
                    dp[i][j] = 2;
                }else if(areSame){

                        dp[i][j] = dp[i + 1][j - 1] + 2;

                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        for(int i = 0 ; i < len; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[len][len];

    }

}
