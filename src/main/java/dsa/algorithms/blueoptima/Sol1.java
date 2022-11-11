package dsa.algorithms.blueoptima;

import java.util.Arrays;

public class Sol1 {
    public static int[][] arrclone(int[][] input) {
        //TODO create a copy of all the elements in input and return to caller.
        int m = input.length;
        int res[][] = new int[m][];
        for(int i = 0 ; i < m; i++){
            if(input[i] != null) {
                res[i] = new int[input[i].length];
                System.arraycopy(input[i],0,res[i],0, input[i].length);
            }else{
                res[i] = null;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] test = new int[3][];
        //test[0] = new int[] {42,456};
        test[2] = null;
        test[1] = new int[] {1,2,3,4,5,6,7,8,8};
        int[][] testClone = arrclone(test);
        test[1][3] = 1000;
        for(int i = 0 ; i <test.length; i++){
            System.out.println(Arrays.toString(test[i]));
        }
        for(int i = 0 ; i <testClone.length; i++){
            System.out.println(Arrays.toString(testClone[i]));
        }

        System.out.println("2nd attempt");

        test = new int[3][20];
        test[0] = new int[] {42,456};
        test[2] = new int[] {1,2,3,4,5,6,7,8,10};
         testClone = arrclone(test);
        for(int i = 0 ; i <testClone.length; i++){
            System.out.println(Arrays.toString(testClone[i]));
        }
         int[] t1;
         t1 = new int[]{1};

        int[] t2 = new int[4];
        int[][] f =  {t1,t2};
        int[][] re = arrclone(f);
        System.out.println("final");
        for(int i = 0 ; i <re.length; i++){
            System.out.println(Arrays.toString(re[i]));
        }

        // System.out.println("test clone value is: " + testClone[0][0]);
    }
}
