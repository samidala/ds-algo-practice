package recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] a ={1,2,2,3,3,3,4,4};
        List<List<Integer>> res = subsets(a);
        System.out.println(res);
    }

    private static List<List<Integer>> subsets(int[] a){

        Arrays.sort(a);
        List<List<Integer>> res = new ArrayList<>();
        subsets(a,0,res,new ArrayList<>());
        return res;
    }
    private static void subsets(int[] a, int index, List<List<Integer>> res, List<Integer> curr){
        res.add(new ArrayList<>(curr));
        for(int i = index; i < a.length;i++){
            if(i != index && a[i] == a[i -1]) continue;
            curr.add(a[i]);
            subsets(a,i+1,res,curr);
            curr.remove(curr.size() - 1);
        }
    }
}
