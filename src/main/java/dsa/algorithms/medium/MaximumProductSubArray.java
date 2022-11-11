package dsa.algorithms.medium;

public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        int n = nums.length, res = nums[0], l = 1, r = 1;
        for (int i = 0; i < n; i++) {
            l =  (l == 0 ? 1 : l) * nums[i];
            r =  (r == 0 ? 1 : r) * nums[n - 1 - i];
            System.out.println(i +" "+ (n-1-i));
            res = Math.max(res, Math.max(l, r));
        }
        return res;
    }
}
