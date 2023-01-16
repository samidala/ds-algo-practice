package dsa.algorithms.dp;
import java.util.* ;
import java.io.*;
public class Cuts {

    public static void main(String[] args) {
        int cost = cost(4,2,new int[]{1,3});
        System.out.println(cost);
    }

    public static int cost(int n, int c, int cuts[]) {

        // Write your code here..
        int[] temp = new int[c+2];
        temp[0] = 0;
        for(int i = 0; i < c;i++){
            temp[i] = cuts[i];
        }
        temp[c+1] = n;
        Arrays.sort(temp);
        System.out.println("array "+Arrays.toString(temp));
        int min = minCost(1,c,temp);
        return min;
    }

    private static int minCost( int i, int j, int[] cuts){
        if(i > j) return 0;
        int min = (int) 1e8;
        for(int ind=i ; ind <= j;ind++){
            int sub = (cuts[j+1] - cuts[i-1]) +
                    minCost(i,ind-1,cuts)
                    + minCost(ind+1,j,cuts);
            min = Math.min(min,sub);
        }
        return min;

    }
}
