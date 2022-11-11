package dsa.algorithms.hard;

public class FindMadianOf2SortArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 10, 10, 18, 20, 23, 27};
        int[] nums2 = {2, 50, 78,90};

        double res = new FindMadianOf2SortArrays().findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            double left = (double) helper(nums1, 0, nums2, 0, len / 2);
            System.out.println("second!!!!!!!!");
            double right = (double) helper(nums1, 0, nums2, 0, len / 2 + 1);
            return (double) (left + right) / 2.0;
        } else {
            return helper(nums1, 0, nums2, 0, len / 2 + 1);
        }

    }

    int helper(int[] nums1, int start1, int[] nums2, int start2, int k) {
        System.out.println(" k "+k);

        if (start1 >= nums1.length) {
            System.out.println("start1 is greater than nums1 length "+start1 +  " and len "+nums1.length);
            return nums2[start2 + k - 1];
        }
        if (start2 >= nums2.length) {
            System.out.println("start2 is greater than nums1 length "+start2 +  " and len "+nums2.length);
            return nums1[start1 + k - 1];
        }
        System.out.println("start1 "+start1 + " start2 "+start2);
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int mid1 = start1 + k / 2 - 1;
        int mid2 = start2 + k / 2 - 1;
        int nums1Val = mid1 >= nums1.length ? Integer.MAX_VALUE : nums1[mid1];
        int nums2Val = mid2 >= nums2.length ? Integer.MAX_VALUE : nums2[mid2];
        if (nums1Val <= nums2Val) {
            return helper(nums1, mid1 + 1, nums2, start2, k - k / 2);
        } else {
            return helper(nums1, start1, nums2, mid2 + 1, k - k / 2);
        }

    }
}
