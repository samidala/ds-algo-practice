package graph;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

public class PrintIncomingEdges {

    public static void main(String[] args) {

        int[][] adjMat = {
              // 0 1 2 3 4 5 6 7 8
                {0,1,1,1,0,0,0,0,0},//0
                {1,0,0,0,1,0,0,0,0},//1
                {1,0,0,0,0,1,1,0,0},//2
                {1,0,0,0,0,0,1,0,0},//3
                {0,1,0,0,0,0,0,0,0},//4
                {0,0,1,0,0,0,0,1,0},//5
                {0,0,1,1,0,0,0,0,0},//6
                {0,0,0,0,0,1,0,0,1},//7
                {0,0,0,0,0,0,0,1,0} //8
        };

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < 9;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0 ; i < 9;i++){
            for(int j = 0 ; j < 9; j++){
                if(adjMat[i][j] == 1) {
                    adjList.get(i).add(j);
                }
            }
        }


        for(int i = 0 ; i < 9 ; i++){
            System.out.println(i+ " "+adjList.get(i));
        }


        System.out.println("*** find incoming edges ***");


    }
}
