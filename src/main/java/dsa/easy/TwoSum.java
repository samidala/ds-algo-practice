package dsa.easy;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{3,2,4},6));
    }
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, List<Integer>> map = new HashMap();

        int[] res = new int[2];
        for(int i = 0 ; i < nums.length;i++){
            if(!map.containsKey(nums[i])){
                List<Integer> list = new ArrayList();
                list.add(i);
                map.put(nums[i],list);
            }else{
                List<Integer> list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i],list);
            }
        }
        for(int i = 0 ; i < nums.length;i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                System.out.println("inside if");
                List<Integer> list = map.get(diff);
                res[0] = i;
                boolean found = false;
                for(int index : list){
                    if(index != i){
                        res[1] = index;
                        found = true;
                    }
                }
                if(found){
                    break;
                }


            }
        }
        System.out.println(map);

        System.out.println(Arrays.toString(res));
        return res;
    }
}
