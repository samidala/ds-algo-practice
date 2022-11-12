package dsa.algorithms.medium;

public class FindPeekElement {
    public int findPeakElement(int[] nums) {
        //if(nums == null || nums.length == 0) return -1;
        // if(nums.length == 1) return 0;
        // if(nums[0] > nums[1]) return 0;
        int n = nums.length;
        // if(nums[n - 1] > nums[n-2]) return n - 1;

        int i = 1;

        while( i < n -1){
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                return i;
            }
            i++;
        }
        return nums[0] > nums[n-1] ? 0 : n -1;
    }
}
