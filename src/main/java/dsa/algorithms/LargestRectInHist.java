package dsa.algorithms;

import java.util.Stack;

public class LargestRectInHist {
    public static void main(String[] args) {
        int a[] = {4, 2, 5, 4, 5, 1, 6};
        System.out.println(largestRectInHist(a));

    }
    public static int largestRectInHist(int[] a){
        int largestRect = 0;

        int i = 0 ;
        int len = a.length;
        Stack<Integer> stack = new Stack<>();//{6, 2, 5, 4, 5, 1, 6};
        while (i < len){
            if(stack.isEmpty() ||  a[i] > a[stack.peek()] ){
               // System.out.println("adding "+i);
                stack.push(i++);
            }else{
                int top = stack.pop();

                int currentRect = a[top] * (stack.empty() ? i : i - stack.peek() - 1);
                System.out.println("i="+i+" top "+top + " a[top] "+a[top]+ " currentRect "
                        +currentRect+ " peek "+(stack.isEmpty() ? " ": stack.peek()) );
                if(currentRect > largestRect){
                    largestRect = currentRect;
                }
            }
        }
        while (!stack.isEmpty()){
            int top = stack.pop();
            int currentRect = a[top]
                    * (stack.empty() ? i : i - stack.peek() - 1);
            System.out.println("currentRect "+currentRect);
            if(currentRect > largestRect){
                largestRect = currentRect;
            }
        }

        return largestRect;
    }
}
