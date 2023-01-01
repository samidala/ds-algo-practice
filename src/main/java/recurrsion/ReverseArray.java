package recurrsion;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(a));
        reverse(a,0,a.length-1);
        System.out.println(Arrays.toString(a));

    }


    static int[] reverse(int[] a, int l,int r){
        if(l >= r){
            return a;
        }
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
        return reverse(a,l+1,r-1);
    }
}
