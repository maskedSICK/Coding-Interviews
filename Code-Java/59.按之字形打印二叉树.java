
/**
* 大家的实现很多都是将每层的数据存进ArrayList中，偶数层时进行reverse操作，在海量数据时，这样效率太低了。
* （我有一次面试，算法考的就是之字形打印二叉树，用了reverse，直接被鄙视了，面试官说海量数据时效率根本就不行。）
* 
* 下面的实现：不必将每层的数据存进ArrayList中，偶数层时进行reverse操作，直接按打印顺序存入
* 思路：利用Java中的LinkedList的底层实现是双向链表的特点。
* 1)可用做队列,实现树的层次遍历
* 2)可双向遍历,奇数层时从前向后遍历，偶数层时从后向前遍历
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

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
    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return list;
        ArrayList<Integer> list1 = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(null);
        queue.addLast(root);
        boolean leftToRight = true;
        while(queue.size() > 1){
            TreeNode node = queue.removeFirst();
            if(node == null){ //到达分隔符
                Iterator iter = null;
                if(leftToRight){
                    iter = queue.iterator();//从前往后遍历
                }
                else{
                    iter = queue.descendingIterator();//从后往前遍历
                }
                leftToRight = !leftToRight;
                while(iter.hasNext()){
                    TreeNode temp = (TreeNode)iter.next();
                    list1.add(temp.val);
                }
                list.add(list1);
                list1 = new ArrayList<>();
                queue.addLast(null);   //添加层分隔符
                continue;
            }
            if(node.left != null)
                queue.addLast(node.left);
            if(node.right != null)
                queue.addLast(node.right);
            
        }
        return list;
    }

}