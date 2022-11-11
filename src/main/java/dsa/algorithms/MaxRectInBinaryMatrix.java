package dsa.algorithms;

import java.util.Stack;

public class MaxRectInBinaryMatrix {
    public static void main(String[] args) {

        int matrix[][] = { { 0, 1, 1, 0 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 }};
        System.out.println("max Rect "+maxRect(matrix) );
        System.out.println("max Rect v1 "+maxRectV1(matrix) );
    }
    static int maxRectV1(int[][] matrix){
        int[] hist = new int[matrix[0].length];

        for(int i = 0 ; i < matrix[0].length;i++){
            int ht = 0;
            for(int j = 0 ; j < matrix.length; j++){
                ht+=matrix[i][j];
            }
            hist[i] = ht;
        }
        int maxArea = 0;
        for(int i = 0 ; i < matrix.length;i++){
            maxArea = Math.max(maxArea,maxRect(matrix[i]));
        }
        return maxArea;

    }
    static int maxRect(int[][] matrix){

        int maxArea = maxRect(matrix[0]); // LargestRectInHist.largestRectInHist(matrix[0]);
        System.out.println("max Area "+maxArea);



        for( int i = 1; i < matrix.length;i++){
            for(int j = 0 ; j < matrix[i].length; j++){
                if(matrix[i][j] == 1){
                    matrix[i][j]+=matrix[i-1][j];
                }
            }
            int area =  maxRect(matrix[i]);
            if(area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;


    }
    static int maxRect(int[] row){
        Stack<Integer> st = new Stack<>();
        int len = row.length;
        int i = 0;
        int maxArea = 0;
        while (i < len){
            if(st.isEmpty() || row[i] > row[st.peek()]){
                st.push(i++);
            }else{
                int top = st.pop();
                int area = row[top] * (st.isEmpty() ? i : i - st.peek() - 1);
                if(area > maxArea){
                    maxArea = area;
                }

            }
        }
        while (!st.isEmpty()){
            int top = st.pop();
            int area = row[top] * (st.isEmpty() ? i : i - st.peek() - 1);
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
}
