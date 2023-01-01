package recurrsion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubSequences {

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        List<List<Integer>> res = new ArrayList<>();
        subSequence(a,0,res,new ArrayList<>());
        System.out.println(res);
    }
    static void subSequence(int[] a,int ind,List<List<Integer>> finalRes,List<Integer> cur){

        if(ind == a.length){
            finalRes.add(new ArrayList<>(cur));
            return;
        }
        if(a[ind] % 2 == 0) {
            cur.add(a[ind]);
            subSequence(a, ind + 1, finalRes, cur);
        }

        if(a[ind] % 2 == 0)
            cur.remove(cur.size() - 1);
        subSequence(a,ind+1,finalRes,cur);
    }
}
