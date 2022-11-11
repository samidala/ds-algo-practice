package dsa.algorithms.hard;

import dsa.easy.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class MaxSumPathInBinaryTree {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        AtomicInteger res = new AtomicInteger(Integer.MIN_VALUE);

        helper(root);

        return maxSum;


    }
    public int helper(TreeNode root){

        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);


        left = Math.max(0,left);
        right = Math.max(0,right);

        maxSum = Math.max(maxSum,left+right+root.val);
        //System.out.println(root.val + " maxSum "+maxSum + " left "+left+ " right "+right);
        return Math.max(left,right) + root.val;

    }
    /*public int helper(TreeNode root, AtomicInteger res){

        if(root == null) return ;
        AtomicInteger l = new AtomicInteger(-1001);
        AtomicInteger r = new AtomicInteger(-1001);
        helper(root.left,l);
        helper(root.right,r);


        int maxSumIncludingOneChild =
          Math.max(Math.max(l.get(),r.get()), Math.max(root.val, root.val + Math.max(l.get(),r.get())));



        int maxIncludingBoth = Math.max(maxSumIncludingOneChild,
                                        l.get()+r.get()+root.val);
        System.out.println(root.val +" maxSumIncludingOneChild "+maxSumIncludingOneChild+ " sum "+maxIncludingBoth + " left "+l.get()+ " right "+r.get());
        if(res.get() < maxIncludingBoth){
            //System.out.println(root.val + " sum "+maxIncludingBoth);
            res.set(maxIncludingBoth);
        }

    }*/

}
