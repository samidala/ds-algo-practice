package dsa.easy;

import java.util.Stack;

public class MinDiffInbst {
    int min = Integer.MAX_VALUE;
    TreeNode prev;

    public int minDiffInBSTUsingStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int minDif = Integer.MAX_VALUE;
        TreeNode prev = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null) {
                minDif = Math.min(minDif, root.val - prev.val);
            }
            prev = root;
            root = root.right;
        }

        return minDif;
    }
    public int minDiffInBST(TreeNode root) {

        minDiffInBSTHelper(root);
        return min;

    }

    public int minDiffInBSTHelper(TreeNode root) {
        if(root == null){
            return min;
        }
        minDiffInBSTHelper(root.left);
        if(prev != null){
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;
        return minDiffInBSTHelper(root.right);

    }
}
