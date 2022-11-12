package dsa.algorithms.medium;

public class FindMaxDiffInMatrix {
    public static int findMaxValue(int mat[][], int n) {
        // Write your code here.

        for(int i=1;i<n;i++){

            if(mat[i-1][0]<mat[i][0]){

                mat[i][0]=mat[i-1][0];

            }

        }

        int ans=Integer.MIN_VALUE;

        for(int i=1;i<n;i++){

            for(int j=0;j<n;j++){

                if(j==0){

                    mat[j][i]=Math.min(mat[j][i],mat[j][i-1]);

                }

                else{

                    ans=Math.max(ans,mat[j][i]-mat[j-1][i-1]);

                    mat[j][i]=Math.min(mat[j][i],Math.min(mat[j-1][i],mat[j][i-1]));

                }

            }

        }

        return ans;



    }
}
