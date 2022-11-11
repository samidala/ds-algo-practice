package dsa.algorithms.medium;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoko {

    public boolean isValidSudoku(char[][] board) {


        //check by row and column

        for(int i = 0 ; i < 9; i++){
            Set<Character> row = new HashSet();
            Set<Character> col = new HashSet();
            Set<Character> sq = new HashSet();
            for(int j = 0; j< 9;j++){
                // int x = i / 3;
                //  int y = j % 3;

                int x = 3*(i/3);
                int y = 3*(i%3);

                if(
                        (board[i][j] != '.' && row.contains(board[i][j])) ||
                                (board[j][i] != '.' && col.contains(board[j][i]))
                ) {
                    //   System.out.println("returning false from here row " + row.contains(board[i][j])
                    //                  +" val "+board[i][j]  +" col "+col.contains(board[j][i])+" val "+board[j][i]
                    //                 +"  square "+col.contains(board[x][y]) +  " val at sq "+board[x][y] + " x "+x + " y "+y);
                    //  System.out.println(sq);
                    return false;
                }
                if(board[i][j] != '.'){
                    row.add(board[i][j]);
                }
                if(board[j][i] != '.'){
                    col.add(board[j][i]);
                }
                if(board[x + j/3][y + j%3] != '.'){
                    if(!sq.add(board[x + j/3][y + j%3])){
                        return false;
                    }
                }
            }
        }


        //check 3 * 3 matrix
      /*  for(int k = 3; k <= 9;k+=3){
            Set<Character> set = new HashSet();
            for(int i = k ; i < k ; i++){
                for(int j =k; j < k;j++ ){
                    if(set.contains(board[i][j])) return false;
                     if(board[i][j] != '.'){
                     set.add(board[i][j]);
                     }
                }
            }
        }*/
        return true;
    }
}
