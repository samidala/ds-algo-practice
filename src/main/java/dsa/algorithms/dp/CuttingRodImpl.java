package dsa.algorithms.dp;

import java.util.Arrays;

import static java.lang.Math.max;

public class CuttingRodImpl {

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
        count++;
        if(len == 0 ){
            return 0;
        }
        int maxProfit = prices[len - 1];
        table[len - 1] = prices[len - 1];
        for( int i = 1; i <= len / 2; i++){
            System.out.println("i is "+i);
           /* if(table[len - i] != -1){
                System.out.println("found value for "+ (len - i));
                return table[len - i];
            }else{
                System.out.println("not found value for "+ (len - i));
            }*/
            maxProfit = max(prices[i-1]+maxProfit(prices,len - i),maxProfit);
            table[len - i] = maxProfit;
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
            for(int j = 0; j <= i / 2; j++){
                //i = 2
                // j = 0 ,1
                // 1+1, 2

                maxVal = Math.max(maxVal, prices[j] + table[i - j -1]);
                System.out.println(j + " "+ (i-j));
            }
            table[i] = maxVal;

        }

        System.out.println(Arrays.toString(table));
        return table[n];
    }


}
