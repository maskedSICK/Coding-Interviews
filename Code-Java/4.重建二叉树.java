/*
����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
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
        //ֻ��һ��Ԫ��ʱ
        if(preStart == preEnd){
            if(inStart == inEnd && pre[preStart] == in[inStart]){
                return root;
            }
            else{
             	return null;
            }	
        }
        //��������������λ��
        int rootIndex = inStart;
        while(rootIndex <= inEnd && in[rootIndex] != rootValue){
            rootIndex++;
        }
        //û�ҵ������ʱ
        if(rootIndex == inEnd && in[rootIndex] != rootValue){
            return null;
        }
        
        int leftLength = rootIndex - inStart;
        int preLeftEnd = preStart + leftLength;
        //����������
        if(leftLength > 0){
            root.left = constructBinaryTree(pre, in, preStart + 1, preLeftEnd, inStart, rootIndex - 1);
        }
        //����������
        if(preEnd - preLeftEnd > 0){
            root.right = constructBinaryTree(pre, in, preLeftEnd + 1, preEnd, rootIndex + 1, inEnd);
        }
        return root;
    }
}