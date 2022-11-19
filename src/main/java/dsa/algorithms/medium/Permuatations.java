package dsa.algorithms.medium;

import java.util.*;
import java.util.stream.Collectors;

public class Permuatations {

    public static void main(String[] args) {
        System.out.println(permuteUsingQueue(new int[] {1,2,3,4}));
        System.out.println(permute(new int[] {1,2,3,4}));
        System.out.println(permuteUsingSwap(new int[] {1,2,3,4}));
    }
    static List<List<Integer>> permuteUsingSwap(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        permute(nums,0,res);
        return res;
    }
    static void permute(int[] nums,int index,List<List<Integer>> res){
        if(index == nums.length){
            List<Integer> curr;
            curr = Arrays.stream(nums).boxed().collect(Collectors.toList());
            res.add(curr);
            return;
        }
        System.out.println(index + " nums "+Arrays.toString(nums));
        for(int i = index ; i < nums.length;i++){
            swap(nums,i,index);
            permute(nums,index+1,res);
            swap(nums,i,index);
        }

    }
    static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        permute(nums,new ArrayList<>(),res,0);
        System.out.println(res);
        return res;
    }
    static void permute(int[] nums, List<Integer> current, List<List<Integer>> res, int index){
        if(nums.length == index){
            List<Integer> perm = new ArrayList<>(current);
            res.add(perm);
            return;
        }
        System.out.println("current is "+current);
        for(int i = 0; i <= current.size(); i++){
            List<Integer> perm = new ArrayList<>(current);
            System.out.println(i + " before adding "+perm);
            perm.add(i,nums[index]);
            System.out.println(i + " after adding "+perm);
            permute(nums,perm,res,index+1);
        }
    }

   static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    static List<List<Integer>> permuteUsingQueue(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(new ArrayList<>());
        for(int n : nums){
            int qSize = q.size();
            for(int i = 0; i < qSize;i++){
                List<Integer> list = q.poll();
                System.out.println("from queue "+list);
                for(int j = 0 ; j <= list.size(); j++){
                    List<Integer> current = new ArrayList<>(list);
                    current.add(j,n);
                    System.out.println("after adding "+n+ " current is "+current);
                    if(current.size() == nums.length){
                        res.add(current);
                    }else{
                        q.offer(current);
                    }
                }
            }
        }
        return res;
    }
}

