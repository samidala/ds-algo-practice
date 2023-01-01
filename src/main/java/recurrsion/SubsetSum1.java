package recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum1 {

    public static void main(String[] args) {
        int[] a = {5,2,1};
        List<Integer> res = subsetSum(a);
        System.out.println(res);
    }
    private static List<Integer> subsetSum(int[] a){
        List<Integer> res = new ArrayList<>((int) Math.pow(2,a.length));
        Arrays.sort(a);
        subsetSum(a,0,0,res);
        return res;

    }
    static void subsetSum(int[] a,int index, int sum, List<Integer> res){
        if(index == a.length){
            res.add(sum);
            return;
        }
        subsetSum(a,index+1, sum+a[index],res);
        subsetSum(a,index+1,sum ,res);
    }
}
