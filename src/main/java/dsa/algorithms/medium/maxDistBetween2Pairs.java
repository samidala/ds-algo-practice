package dsa.algorithms.medium;

public class maxDistBetween2Pairs {
    public int maxDistance(int[] nums1, int[] nums2) {

        int first = 0;
        int second = 0;
        int m = nums1.length;
        int n = nums2.length;
        int maxDist = 0;
        while(first < m && second < n){
            if(nums1[first] <= nums2[second]){
                maxDist = Math.max(maxDist, second - first);
                second++;
            }else{
                //while(first < m && nums1[first]> nums2[second] ){
                first++;
                //  }
            }
        }
        return maxDist;
    }
}
