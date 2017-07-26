/*
请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

思路：左子树的左子树和右子树的右子树相同
      左子树的右子树和右子树的左子树相同即可，采用递归

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