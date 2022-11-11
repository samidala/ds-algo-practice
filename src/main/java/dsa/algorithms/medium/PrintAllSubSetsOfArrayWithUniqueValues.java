package dsa.algorithms.medium;
import java.util.*;

public class PrintAllSubSetsOfArrayWithUniqueValues {

    public static void main(String[] args) {
        int val = 10;
        System.out.println(Integer.toBinaryString(val));
        /**
         * 1000
         */
        val =  (val >> 2);
        System.out.println(Integer.toBinaryString(val));

        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
        List<List<Integer>> res = subsetUsingBits(nums);
        System.out.println(res);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> empty = new ArrayList();
        res.add(empty);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int n = nums[i];
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> nl = new ArrayList(res.get(j));
                nl.add(n);
                res.add(nl);
            }
        }
        //          dfs(nums,res, new ArrayList<Integer>(),0);

        return res;
    }

    void dfs(int[] nums, List<List<Integer>> res, List<Integer> tempList, int start) {

        res.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            dfs(nums, res, tempList, i + 1);
            tempList.remove(tempList.size() - 1);
        }

    }

    public  static List<List<Integer>> subsetUsingBits(int[] S) {
        Arrays.sort(S);
        int totalNumber = 1 << S.length;
        List<List<Integer>> collection = new ArrayList<List<Integer>>(totalNumber);
        for (int i=0; i<totalNumber; i++) {
            List<Integer> set = new LinkedList<Integer>();
            for (int j=0; j<S.length; j++) {
                if ((i & (1<<j)) != 0) {
                    set.add(S[j]);
                }
            }
            collection.add(set);
        }
        return collection;
    }
}
