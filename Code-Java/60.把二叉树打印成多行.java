/*
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
*/

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode enter = root;
        TreeNode last = root;
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list1.add(node.val);
            if(node.left != null){
                queue.offer(node.left);
                last = node.left;
            }
            if(node.right != null){
                queue.offer(node.right);
                last = node.right;
            }
            if(node == enter){
                list.add(list1);
                list1 = new ArrayList<Integer>();
                enter = last;
            }
        }
        return list;
    }
    
}