package dsa.algorithms.dp;

public class FrogJump {

    public static void main(String[] args) {
        int n = 4;
        int hts[] = {10 ,20 ,30, 10};
        int min = frogJump(n,hts);
        System.out.println(min);
    }

    public static int frogJump(int n, int heights[]) {

        // Write your code here..

        return frogJumpRecur(n-1,heights);
    }

    public static int frogJumpRecur(int n, int heights[]) {

        // Write your code here..
        System.out.println("n is "+n);
        if(n == 0)
            return 0;

        int oneStep = frogJumpRecur(n-1,heights) + Math.abs(heights[n-1] - heights[n]);
        int twoSteps = Integer.MAX_VALUE;
        if(n > 1){
            twoSteps = frogJumpRecur(n-2,heights) + Math.abs(heights[n-2] - heights[n]);
        }
        return Math.min(oneStep,twoSteps);
    }


}
