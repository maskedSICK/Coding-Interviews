/*
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
思路：
（1） 若该节点存在右子树：则下一个节点为右子树最左子节点（如图节点 B ）
（2） 若该节点不存在右子树：这时分两种情况：
2.1 该节点为父节点的左子节点，则下一个节点为其父节点（如图节点 D ）
2.2 该节点为父节点的右子节点，则沿着父节点向上遍历，直到找到一个节点的父节点的左子节点为该节点，
则该节点的父节点为下一个节点（如图节点 I ，沿着父节点一直向上查找找到 B （ B 为其父节点的左子节点），则 B 的父节点 A 为下一个节点）。
            A
		   /  \
		  B    C
		 / \  / \
        D  E  F  G
		  / \
		 H   I
*/

/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode node)
    {
        if(node == null)
            return null;
        //有右子树的，那么找其右子树的最左的结点
        if(node.right != null){ 
            node = node.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }
        //无右子树的
        //node是父结点的左孩子
        if(node.next != null && node.next.left == node)
            return node.next;
        //node是父结点的右孩子
        while(node.next != null){
            if(node.next.left == node)
                return node.next;
            node = node.next;
        }
        return null;
    }
}