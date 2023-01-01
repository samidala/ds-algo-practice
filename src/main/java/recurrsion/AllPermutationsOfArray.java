package recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPermutationsOfArray {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        List<List<Integer>> res = permute(a);
        System.out.println(res);
    }

    static int fact(int n){
        int res = 1;
        for(int i = 1; i <=n;i++){
            res*=i;
        }
        return res;
    }
    private static List<List<Integer>> permute(int[] a){
        List<List<Integer>> res = new ArrayList<>(fact(a.length));
        permute(a,0,res);
        return res;
    }
    private static void permute(int[] a, int index,List<List<Integer>> res){
        if(index == a.length){
            List<Integer> cur = new ArrayList<>();
            for(int x : a){
                cur.add(x);
            }
            res.add(cur);
            return;
        }
        for(int i = index; i < a.length;i++){
            swap(a,index,i);
            permute(a,index+1,res);
            swap(a,index,i);
        }
    }
    static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
