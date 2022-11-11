package dsa.algorithms.medium;

public class RotateImage {
    public static void main(String[] args) {
        int[][] image = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(image);
    }
    public static void rotate(int[][] matrix) {

        int s = 0, e = matrix.length - 1;
        while(s < e){
            int[] temp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = temp;
            s++; e--;
        }
       /* for(int i = 0 ; i < matrix.length;i++){
            for(int j = 0 ; j < matrix.length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }*/
        // System.out.println("transpose done before ");
        for(int i = 0 ; i < matrix.length;i++){
            for(int j=i+1; j<matrix.length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


    }
}
