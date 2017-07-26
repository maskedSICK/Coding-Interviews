/*
��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�

˼·����������������������������������ͬ
      ��������������������������������ͬ���ɣ����õݹ�

*/

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
    boolean isSymmetrical(TreeNode root)
    {
        if(root == null)
            return true;
        boolean result = mirror(root.left, root.right);
        return result;
    }
    
    boolean mirror(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        else if(left == null || right == null)
            return false;
        return (left.val == right.val) && mirror(left.left, right.right) && mirror(left.right, right.left);
    }
}