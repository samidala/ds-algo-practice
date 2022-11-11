package dsa.algorithms.medium;

public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {

        int low = 0, high = nums.length - 1;
        while ( low <= high){
            int mid = low + (high - low)/2;
            // System.out.println(mid + "mid val "+nums[mid] + " high "+high + " low "+low);
            if(nums[mid] == target) {
                return mid;
            }else if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target < nums[mid]){
                    high = mid -1;
                }else{
                    low = mid + 1;
                }
            }else if(nums[high] >= nums[mid]){
                if(target <= nums[high] && target > nums[mid]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;

    }
}
