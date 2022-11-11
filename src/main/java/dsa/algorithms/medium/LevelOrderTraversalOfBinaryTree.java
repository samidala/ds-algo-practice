package dsa.algorithms.medium;

import dsa.easy.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalOfBinaryTree {

    public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList();
        q.offer(root);

        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> list = new ArrayList();
            for(int i = 0 ; i < sz;i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }

            }
            res.add(list);
        }

        return res;
    }

    public List<List<Integer>> levelOrderDfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }
}
