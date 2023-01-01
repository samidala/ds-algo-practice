package recurrsion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubSeqWhoseSumIsK {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,10,13,34,34,43};
        List<List<Integer>> res = new ArrayList<>();
        int k = 8;
        subSeqSumIsEqualToK(a,0,k,new ArrayList<>(),res);
        System.out.println(res);
    }
    static void subSeqSumIsEqualToK(int[] a,int index, int k, List<Integer> cur, List<List<Integer>> res){
        if(k == 0){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(index == a.length){
            return;
        }
        cur.add(a[index]);
        subSeqSumIsEqualToK(a,index+1,k - a[index],cur,res);
        cur.remove(cur.size() - 1);
        subSeqSumIsEqualToK(a,index + 1,k,cur,res);
    }
}
