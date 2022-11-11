package dsa.easy;

import java.util.Arrays;

public class RemoveDuplicatesInArray {

    public static void main(String[] args) {
        int[] a = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDups(a));
        System.out.println(Arrays.toString(a));
    }
    public static int removeDups(int[] a){
        int n = a.length;
        int left = 1;
        int right = 1;
        while (right < n){
            if(a[left -1] != a[right]){
                a[left++] = a[right];
            }
            right++;
        }
        return left;
    }
    public int removeDuplicates(int[] nums) {

        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums)
            if (n > nums[i-1])
                nums[i++] = n;
        System.out.println("i "+i);
        return i;

    }
    public int removeDuplicatesV2(int[] nums) {

        int count = 0;
        int n = nums.length;
        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i-1]) count++;
            else nums[i-count] = nums[i];
        }
        return n-count;

    }
}
