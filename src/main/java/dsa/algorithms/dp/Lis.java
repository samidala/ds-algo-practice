package dsa.algorithms.dp;

public class Lis {


    public static void main(String[] args) {

        int[] arr = {5,5,5,5,5,5,5,5,5,5};
        int lis = longestIncreasingSubsequence(arr);
        System.out.println(lis);


    }
    public static int longestIncreasingSubsequence(int arr[]) {
        //Your code goes here
        int max = lis(arr,0,-1);
        // System.out.println(maxi);
        return max;
    }

    private static int lis(int[] arr, int ind,int prev){
        if(ind == arr.length){
            return 0;
        }

        int notTake = lis(arr,ind+1,prev);
        int take = 0;
        if(prev == -1 || arr[prev] < arr[ind]){
            take = lis(arr,ind+1,ind) + 1;
        }

        int max = Math.max(take,notTake);

        return max;



    }
}
