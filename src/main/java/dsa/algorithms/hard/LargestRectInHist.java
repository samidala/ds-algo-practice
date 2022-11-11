package dsa.algorithms.hard;

import java.util.Stack;

public class LargestRectInHist {

    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int res = largestRectangleArea(heights);
        System.out.println(res);
    }
    public static int largestRectangleArea(int[] heights) {

        if(heights == null || heights.length == 0){
            return 0;
        }

        if(heights.length == 1){
            return heights[0];
        }

        Stack<Integer> st = new Stack();
        st.push(0);
        int len = heights.length;
        int maxArea = 0;
        for(int i = 1 ; i < len ;){
            if(st.isEmpty() || heights[i] >= heights[st.peek()]){
                st.push(i++);
                System.out.println("if condition st size "+st.size());
            }else{
                int top = st.pop();
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxArea = Math.max(maxArea,heights[top] * width);
            }
        }
        while(!st.isEmpty()) {
            int top = st.pop();
            int width = st.isEmpty() ? len : len - st.peek() - 1;
            maxArea = Math.max(maxArea,heights[top] * width);

        }



        return maxArea;
    }
}
