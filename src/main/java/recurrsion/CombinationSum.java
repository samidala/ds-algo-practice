package recurrsion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] a = {2,3,6,7};
        int sum = 7;
        List<List<Integer>> res = new ArrayList<>();
        comboSum(a,0,new ArrayList<>(),res,sum);
        System.out.println(res);
    }
    static void comboSum(int[] a, int index, List<Integer> cur, List<List<Integer>> res, int sum){
        if(sum == 0){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(sum < 0) return;
        if(index == a.length) return;
        cur.add(a[index]);
        comboSum(a,index,cur,res,sum - a[index]);
        cur.remove(cur.size() - 1);
        comboSum(a,index+1,cur,res,sum);
    }
}
