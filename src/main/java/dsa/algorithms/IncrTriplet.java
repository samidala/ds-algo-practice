package dsa.algorithms;

public class IncrTriplet {
    public static void main(String[] args) {
        int[] nums = new int[]{22,12,5,4,4,6};
        System.out.println(increasingTriplet(nums));


        int res = (int) Math.pow(2,28);

    }
    public static boolean increasingTriplet(int[] nums) {

        int first = nums[0];
        int second = nums[1] > nums[0] ? nums[1] : Integer.MAX_VALUE;
        boolean res = false;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > first && nums[i] > second){
                res = true;
                break;
            }else{
                if(nums[i] < first){
                    first = nums[i];
                    second = Integer.MAX_VALUE;
                }else if(nums[i] != first){
                    second = nums[i];
                }
            }
        }
        return res;

    }
}
