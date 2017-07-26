/*
先序遍历对二叉树进行序列化
1.假设序列化结果为str，初始为空
2.先序遍历二叉树时如果遇到空节点，str末尾添加“#！”
3.如果遇到不为空的节点，假设节点值为3，在str末尾添加“3！”
注意点：
1.#代表空节点，每个节点后添加结束符！（如果不添加结束符，会产生歧义，如12，是表示1，2还是12？）
2.用什么遍历方式序列，就要用什么方式反序列化（先序序列化，反序列化时就要用先序创建二叉树）

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
    int index = -1;
    
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("#!");
            return sb.toString();
        }
        sb.append(root.val + "!");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    
    TreeNode Deserialize(String str) {
        index++;
        String[] strs = str.split("!");
        TreeNode node = null;
        if(!strs[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strs[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}