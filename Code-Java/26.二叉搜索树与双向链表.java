/*
����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
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
    TreeNode lastNode = null;  //ָ����������һ�����
    
    public TreeNode Convert(TreeNode root) {
        //TreeNode lastNode = null;  //ָ����������һ�����
        ConvertNodes(root);
        while(lastNode != null && lastNode.left != null)
            lastNode = lastNode.left;
        return lastNode;
    }
    
    public void ConvertNodes(TreeNode root){
        if(root == null)
            return;
        //������
        ConvertNodes(root.left);
        if(lastNode != null)
        	lastNode.right = root;
        root.left = lastNode;
        lastNode = root;
        //������
        ConvertNodes(root.right);
    }
}