package recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationWithDuplicates {

    public static void main(String[] args) {
        int[] a = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum(a,target));
    }

    static List<List<Integer>> combinationSum(int[] a, int target){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(a);
        combinationSum(a,target,0,res, new ArrayList<>());
        return res;
    }
    static void combinationSum(int[] a, int target, int index,List<List<Integer>> res, List<Integer> curr){
        if(target == 0){
            res.add(new ArrayList<>(curr));
        }
        if(index == a.length){
            return;
        }
        if(target < 0){
            return;
        }

       /* if(index == 0 || a[index -1] != a[index] && a[index] <= target){
            curr.add(a[index]);
            combinationSum(a,target - a[index],index+1,res,curr);
            curr.remove(curr.size() - 1);
        }else{
            combinationSum(a,target,index + 1, res,curr);
        }*/

        for(int i = index; i < a.length; i++){
            if(i > index && a[i-1] == a[i]) continue;
            if(a[i] > target) break;
            curr.add(a[i]);
            combinationSum(a,target - a[i],i+1,res,curr);
            curr.remove(curr.size() - 1);
        }


    }

}
