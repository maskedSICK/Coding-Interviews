/*
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
*/

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
    TreeNode lastNode = null;  //指向链表的最后一个结点
    
    public TreeNode Convert(TreeNode root) {
        //TreeNode lastNode = null;  //指向链表的最后一个结点
        ConvertNodes(root);
        while(lastNode != null && lastNode.left != null)
            lastNode = lastNode.left;
        return lastNode;
    }
    
    public void ConvertNodes(TreeNode root){
        if(root == null)
            return;
        //左子树
        ConvertNodes(root.left);
        if(lastNode != null)
        	lastNode.right = root;
        root.left = lastNode;
        lastNode = root;
        //右子树
        ConvertNodes(root.right);
    }
}