package dsa.algorithms.medium;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int c = matrix[0].length - 1;
        int r = 0;

        while(c >= 0 && r < matrix.length){
            //System.out.println("matrix[r][c] "+matrix[r][c]);
            if(matrix[r][c] == target){
                return true;
            }else if(matrix[r][c] > target){
                c--;
            }else{
                r++;
            }
        }
        return false;

    }
}
