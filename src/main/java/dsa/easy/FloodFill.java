package dsa.easy;
import java.util.*;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        Queue<int[]> q = new LinkedList();
        int oldColor = image[sr][sc];
        q.offer(new int[] {sr,sc});
        while(!q.isEmpty()){
            int[] current = q.poll();
            int sr1 = current[0];
            int sc1 = current[1];
            if(sr1 <0 || sr1 >= image.length || sc1 < 0 || sc1 >= image[sr1].length
                    || image[sr1][sc1] != oldColor){
                continue;
            }
            image[sr1][sc1] = color;
            q.offer(new int[] {sr1+1,sc1});
            q.offer(new int[] {sr1-1,sc1});
            q.offer(new int[] {sr1,sc1-1});
            q.offer(new int[] {sr1,sc1+1});
        }
        //floodFillHelper(image,sr,sc,image[sr][sc],color);
        return image;
    }
    private void floodFillHelper(int[][] image, int sr, int sc,int color,int newColor){
        if(sr < 0 || sr >= image.length
                || sc < 0 || sc >= image[sr].length
                || image[sr][sc] != color){
            return;
        }
        image[sr][sc] = newColor;
        floodFillHelper(image,sr-1,sc,color,newColor);
        floodFillHelper(image,sr+1,sc,color,newColor);
        floodFillHelper(image,sr,sc+1,color,newColor);
        floodFillHelper(image,sr,sc-1,color,newColor);


    }
}
