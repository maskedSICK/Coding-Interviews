/*
方案一：递归求左右子树的深度
方案二：先判断左右子树是否为平衡二叉树，再判断当前，需要保存是否为平衡二叉树和高度

*/

public class Solution {
	
    /*
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)
            return true;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if(left - right > 1 || left - right < -1)
            return false;
        return true;
    }
    
    public int TreeDepth(TreeNode root){
        if(root == null)
            return 0;
        int left = TreeDepth(root.left) + 1;
        int right = TreeDepth(root.right) + 1;
        return left > right ? left : right;
    }
    */
    public boolean IsBalanced_Solution(TreeNode root){
        int[] depth = new int[1];
		return isBalanced(root, depth);

    }
    
    public boolean isBalanced(TreeNode root, int[] depth) {
		if (root == null) {
			depth[0] = 0;
			return true;
		}
		
		int[] leftDepth = new int[1];
		boolean leftIsBalanced = isBalanced(root.left, leftDepth);

		int[] rightDepth = new int[1];
		boolean rightIsBalanced = isBalanced(root.right, rightDepth);
		if (leftIsBalanced && rightIsBalanced){
            if (Math.abs(leftDepth[0] - rightDepth[0]) <= 1) {
                depth[0] = Math.max(leftDepth[0], rightDepth[0]) + 1;
				return true;
			}
        }
		return false;
	}

}