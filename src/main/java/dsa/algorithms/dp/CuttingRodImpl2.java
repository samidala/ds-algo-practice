package dsa.algorithms.dp;

import java.util.Arrays;

import static java.lang.Math.max;

public class CuttingRodImpl2 {

    //static int maxProfit = 0;
    static int count = 0;

    public static void main(String[] args) {
        int[] prices = { 1, 5, 8, 9, 10, 17, 17, 20 };
        prices = new int[]{1, 3, 3, 3, 4, 4, 6};
        table = new int[prices.length];
        Arrays.fill(table,-1);;
        System.out.println(Arrays.stream(prices).sum());
        int len = prices.length;
        int maxProfit = maxProfit(prices,len);
        System.out.println("max profit using recur "+maxProfit);
        System.out.println("total execution "+count);
        maxProfit = maxProfit(prices);
        System.out.println("using DP "+maxProfit);

    }


    static int len = 0;
    static int[] table = new int[len];
    static int maxProfit(int[] prices, int len){
        if(len == 0 ){
            return 0;
        }
        int maxProfit = prices[len - 1]; // do not cut
        for( int i = 1; i <= len / 2; i++){
            maxProfit = max(prices[i-1]+maxProfit(prices,len - i),maxProfit);
            // cut at i and recur for len - i
            // for example, len = 8, cut is made at i = 3, recur for 8 (len) - 3 = 5 and goes on..
            //find max profit and update to max profit and return max profit
        }

        return maxProfit;
    }

    static int maxProfit(int[] prices){
        int n = prices.length;
        int result = 0;
        int[] table = new int[n+1];
        table[0] = 0;
        table[1] = prices[0];
        for(int i = 1; i <= n; i++){
            int maxVal = prices[i-1];

            System.out.println("length "+i);
            /**
             * j will be up to (i/2) to avoid duplicate processing
             * for example, i = 4, possible values
             *  1 3
             *  4 0
             *  3 1
             *  2 2
             *  and i = 5
             *  0 5
             *  1 4
             *  2 3
             *  3 2
             *  4 1
             */
            for(int j = 0; j <= i / 2; j++){
                maxVal = Math.max(maxVal, prices[j] + table[i - j -1]);
                System.out.println(j + " "+ (i-j));
            }
            table[i] = maxVal;
        }
        System.out.println(Arrays.toString(table));
        return table[n];
    }
}
