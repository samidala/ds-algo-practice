package dsa.algorithms.medium;

import dsa.easy.TreeNode;

public class LowesetCommonAnsistorInBst {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode result = null;
        if(p.val > q.val){
            TreeNode t = p;
            p = q;
            q = t;

        }
        while(result == null && root != null){
            if(p.val <= root.val && q.val >= root.val){
                result = root;
            }else if(p.val < root.val && q.val < root.val){
                root = root.left;
            }else {
                root = root.right;
            }
        }
        return result;

    }
    /*public TreeNode lowestCommonAncestorHelper(TreeNode root, TreeNode node) {
        if(root == null){
            return null;
        }
        if(root.left != null && root.left == node){
            return root;
        }
        if(root.right != null && root.right == node){
            return root;
        }

        TreeNode left = lowestCommonAncestorHelper(root.left,node);
        if(left != null){
            return left;
        }
        return lowestCommonAncestorHelper(root.right,node);

    }*/
}
