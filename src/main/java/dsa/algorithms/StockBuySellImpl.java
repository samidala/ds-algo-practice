package dsa.algorithms;

import java.util.ArrayList;
import java.util.List;

public class StockBuySellImpl {
    public static void main(String args[]){
        int prices[] = {100, 180, 260, 310, 40, 535, 695};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
        List<Interval> list = maxProfilt(prices);
        maxProfit = 0 ;
        for(Interval interval : list){
            System.out.println(interval.buyIndex + " "+interval.sellIndex);
            maxProfit+= prices[interval.sellIndex] - prices[interval.buyIndex];
        }

        System.out.println(maxProfit);

    }
    private static int maxProfit(int[] prices){
        //{100, 180, 260, 310, 40, 535, 695}
        int maxProfit = 0 ;
        int len = prices.length;
        for(int i = 1 ; i < len; i++){
            if(prices[i] > prices[i-1]){
                maxProfit+= prices[i] - prices[i-1];
            }
        }
        return maxProfit;


    }

    private static List<Interval> maxProfilt(int[] prices){
        int n = prices.length;
        List<Interval> list = new ArrayList();
        int i = 0 ;
        while(i < n){
            while( i < n -1 && prices[i] >= prices[i+1] ){
                i++;
            }
            if (i == n - 1)
                break;
            Interval in = new Interval();
            in.buyIndex = i++;
            while (i < n  && prices[i] >= prices[i-1]){
                i++;
            }
            in.sellIndex = i-1;
            list.add(in);
        }
        return list;
    }
    static class Interval{
        int buyIndex, sellIndex;
    }
}

