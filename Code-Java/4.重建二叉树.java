/*
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if(pre == null || in == null || pre.length == 0){
            return null;
        }
        return constructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }
    
    public TreeNode constructBinaryTree(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd){
        int rootValue = pre[preStart];
        TreeNode root = new TreeNode(rootValue);
        //只有一个元素时
        if(preStart == preEnd){
            if(inStart == inEnd && pre[preStart] == in[inStart]){
                return root;
            }
            else{
             	return null;
            }	
        }
        //根结点在中序里的位置
        int rootIndex = inStart;
        while(rootIndex <= inEnd && in[rootIndex] != rootValue){
            rootIndex++;
        }
        //没找到根结点时
        if(rootIndex == inEnd && in[rootIndex] != rootValue){
            return null;
        }
        
        int leftLength = rootIndex - inStart;
        int preLeftEnd = preStart + leftLength;
        //构建左子树
        if(leftLength > 0){
            root.left = constructBinaryTree(pre, in, preStart + 1, preLeftEnd, inStart, rootIndex - 1);
        }
        //构建右子树
        if(preEnd - preLeftEnd > 0){
            root.right = constructBinaryTree(pre, in, preLeftEnd + 1, preEnd, rootIndex + 1, inEnd);
        }
        return root;
    }
}