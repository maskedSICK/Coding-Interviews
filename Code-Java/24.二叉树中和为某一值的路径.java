/*
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

思想：前序遍历变种
*/

import java.util.ArrayList;
import java.util.Stack;
/**
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
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();  //路径集合
        if(root == null)
            return pathList;
        Stack<Integer> path = new Stack<Integer>();  //某条路径
		findPath(root, target, pathList, path);
        return pathList;
    }
    
    public void findPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> pathList, Stack<Integer> path){
        if(root == null)
            return;
        //叶结点  path不包括叶结点
        if(root.left == null && root.right == null){
            if(root.val == target){
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int i : path)
                    list.add(i);
                list.add(root.val);
                pathList.add(list);
            }            
        }
        else{  //非叶结点
            path.push(root.val);
            findPath(root.left, target - root.val, pathList, path);
        	findPath(root.right, target - root.val, pathList, path);
            path.pop();
        }        
    }
}