package dsa.easy;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while(left <= right){
            mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }

        return left;


    }
}
