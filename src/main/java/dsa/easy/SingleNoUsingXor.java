package dsa.easy;

public class SingleNoUsingXor {
    public int singleNumber(int[] nums) {

        int res = 0;
        for(int n : nums){
            res = res^n;
        }
        return res;

    }
}
