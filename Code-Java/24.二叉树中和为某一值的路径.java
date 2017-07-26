/*
����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����

˼�룺ǰ���������
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
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();  //·������
        if(root == null)
            return pathList;
        Stack<Integer> path = new Stack<Integer>();  //ĳ��·��
		findPath(root, target, pathList, path);
        return pathList;
    }
    
    public void findPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> pathList, Stack<Integer> path){
        if(root == null)
            return;
        //Ҷ���  path������Ҷ���
        if(root.left == null && root.right == null){
            if(root.val == target){
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int i : path)
                    list.add(i);
                list.add(root.val);
                pathList.add(list);
            }            
        }
        else{  //��Ҷ���
            path.push(root.val);
            findPath(root.left, target - root.val, pathList, path);
        	findPath(root.right, target - root.val, pathList, path);
            path.pop();
        }        
    }
}