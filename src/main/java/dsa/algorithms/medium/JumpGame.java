package dsa.algorithms.medium;

public class JumpGame {

    public boolean canJump(int[] nums) {

        int reach = 0; // intial reach is 0
        for(int i=0;i<=reach;i++){
            reach= Math.max(reach , i+nums[i]);
            //change reach to max possible value from the ith place
            //reach will be having higher value

            /* for input, 1,3,3,4,5,1,1,1,0,1

                    when 0 - reach is 1
                    when 1 - reach is 4
                    when 2 - reach is 5
                    when 3 - reach is 7
                    when 4 - reach is 9
            */
            /* for input, 1,2,3,0,0,1
            when 0 - reach is 1
            when 1 - reach is 3
            when 2 - reach is 5
            when 3 - reach is 5
            when 4 - reach is 5
            when 5 - reach is 5
            */
            //System.out.println("when "+i+" - reach is "+reach);
            if(reach>=nums.length-1){
                return true;
            }
        }
        return false;


    }
    boolean helper(int[] a,int i){
        if(i > a.length){
            return false;
        }
        if(i == a.length) return true;
        int v = a[i];
        if(v == 0 && a.length - 1 == i){
            return true;
        }
        boolean canJump = false;
        for(int j = 1; j <= v && j < a.length;j++){
            canJump = helper(a,i+1);
        }
        return canJump;
    }
}
