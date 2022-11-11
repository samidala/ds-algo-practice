package dsa.algorithms.medium;

import dsa.easy.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class KthSmallestInBst {
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {


        if(root == null) return -1;
        return kthSmallestHelper(root,k).val;


    }
    TreeNode kthSmallestHelper(TreeNode root, int k){
        if(root == null){
            return null;
        }
        TreeNode left = kthSmallestHelper(root.left,k);
        if(left != null){
            return left;
        }
        count++;
        if(k == count){
            return root;
        }

        return kthSmallestHelper(root.right,k);

    }

    TreeNode kthSmallestHelper(TreeNode root, AtomicInteger ai){
        if(root == null){
            return null;
        }
        TreeNode left = kthSmallestHelper(root.left,ai);
        if(left != null){
            return left;
        }
        //  System.out.println(ai.get());
        ai.getAndDecrement();
        if(ai.get() == 0){
            return root;
        }

        return kthSmallestHelper(root.right,ai);

    }
}
