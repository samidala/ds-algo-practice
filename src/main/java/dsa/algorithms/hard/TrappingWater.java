package dsa.algorithms.hard;

public class TrappingWater {

    public int trap(int[] height) {
        int maxLeft = 0 ;
        int maxRight = 0;
        int res = 0;
        int left = 0 ;
        int right = height.length - 1;
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] > maxLeft){
                    maxLeft = height[left];
                }else{
                    res+=maxLeft-height[left];
                }
                left++;
            }else{
                if(height[right] > maxRight){
                    maxRight = height[right];
                }else{
                    res+=maxRight-height[right];
                }
                right--;
            }
        }
        return res;
    }
    public int trapV1(int[] height) {

        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        maxLeft[0] = height[0];
        maxRight[height.length - 1] = height[height.length -1];
        for(int i = 1; i < height.length; i++){
            maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
        }

        for(int i = height.length - 2; i >= 0; i--){
            maxRight[i] = Math.max(maxRight[i+1],height[i]);
        }

        int res = 0;
        for(int i = 1 ; i <height.length -1;i++){
            res+= (Math.min(maxLeft[i], maxRight[i]) - height[i]) ;

        }
        //System.out.println(Arrays.toString(maxLeft));
        // System.out.println(Arrays.toString(maxRight));

        return res;
    }
}
