package dsa.algorithms.medium;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class MaxSumSubArray {

    public static void main(String[] args) {
        int[] a = {5,4,-4,7,8};//{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("maxSUm "+maxSum(a));
        System.out.println("maxSUm "+maxSumDev(a,0,a.length-1));
        System.out.println("maxSumArray "+maxSubArray(a));
        System.out.println("exec count "+count);
    }
    static int maxSum(int[] a){
        int maxSum = a[0];
        int sum = a[0];
        for(int i =1; i < a.length;i++){
            int n = a[i];
            sum = Math.max(n,n+sum);
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
    public static int maxSubArray(int[] nums) {

        return helper(nums,0,nums.length-1);
    }
    static int count = 0;

    static int helper(int nums[],int i,int j){


        if(i==j){
            count++;
            return nums[i];
        }

        int mid  =  (i+j)/2;
        int sum = 0,leftMaxSUM = Integer.MIN_VALUE;

        for(int l =  mid;l>=i;l--){
            count++;
            System.out.println("reading val "+nums[l]);
            sum+=nums[l];
            if(sum>leftMaxSUM){
                leftMaxSUM =  sum;
            }
        }

        int rightMaxSUM = Integer.MIN_VALUE;
        sum = 0;    // reset sum to 0
        for (int l = mid + 1; l <=j; l++)
        {
            System.out.println("reading val "+nums[l]);
            count++;
            sum += nums[l];
            if (sum > rightMaxSUM ) {
                rightMaxSUM = sum;
            }
        }

        int maxLeftRight = Math.max(helper(nums, i, mid),
                helper(nums, mid + 1, j ));
        return Math.max(maxLeftRight, leftMaxSUM + rightMaxSUM );



    }
    static int maxSumDev(int[] a,int low, int high){

        if(low == high){
            return a[low];
        }

      int mid = (low + high) / 2;
        int sum = 0;
        int left = Integer.MIN_VALUE;
        for(int i = mid ; i >= low;i--){
            sum+=a[i];
            if(sum > left){
                left = sum;
            }
        }
        sum = 0;
        int right = Integer.MIN_VALUE;

        for(int i = mid+1 ; i <=high;i++){
            sum+=a[i];
            if(sum > right){
                right = sum;
            }
        }

        int maxLeftRight = Math.max(maxSumDev(a,low,mid),
                maxSumDev(a,mid+1,high));
        return Math.max(maxLeftRight,left+right);

    }


}
