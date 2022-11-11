package dsa.algorithms.medium;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0;
        int i = 0 ;
        int j = height.length - 1;
        while( i < j){
            int diff = j - i;
            max = Math.max(max, diff * (Math.min(height[i],height[j])));
            if(height[i] < height[j]){
                int preMax = height[i];
                i++;
                while(height[i] < preMax){
                    i++;
                }

            }else{
                int preMax = height[j];
                j--;
                while(height[j] < preMax){
                    j--;
                }
            }
        }
        return max;
    }
    public int maxAreaV1(int[] height) {

        int n = height.length;
        int leftMost = height[0];
        int rightMost = height[n-1];
        int leftMax = 0;
        int rightMax = 0;
        int maxArea = 0;
        int i = 0;
        int j = n - 1;
        while( i < j){


            if(leftMax  < height[i] || rightMax < height[j]){
                int diff = j - i;
                int min = Math.min(height[i],height[j]);
                if(leftMax  < height[i]){
                    leftMax = height[i];
                }
                if(rightMax < height[j]){
                    rightMax = height[j]   ;
                }
                int area = min * diff;
                if(area > maxArea){
                    maxArea = area;
                }
            }

            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }


        }
        return maxArea;


    }
}
