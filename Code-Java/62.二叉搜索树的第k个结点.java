/*
µÝ¹é£ºÖÐ¸ù±éÀú
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
    int index = 0;
    TreeNode KthNode(TreeNode root, int k)
    {
        if(root == null)
            return null;
        TreeNode result = KthNode(root.left, k);
        if(result != null)
            return result;
        if(++index == k)
            return root;
        result = KthNode(root.right, k);
        if(result != null)
            return result;
        return null;
    }

}