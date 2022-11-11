package dsa.algorithms;

import java.util.PriorityQueue;

public class RodCutting
{
    static int cutRod(int price[], int n)
    { 	int i;
        if (n <= 0)
            return 0;
        int max_val = Integer.MIN_VALUE;
        for( i=0;i<price.length-1;i++){
            if (n%(i+1) ==0){
                int d = n/(i+1);
                max_val = Math.max(max_val,d*price[i]);
                max_val = Math.max(max_val,(price[i] + price[n-i-2]));
            }
            else{
                max_val = Math.max(max_val,(price[i] + price[n-i-2]));
            }
        }
        max_val = Math.max(max_val,(price[i]));
        return max_val;
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        arr = new int[]{1, 3, 3, 3, 4, 4, 6};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is "+
                cutRod(arr, size));

    }
}

