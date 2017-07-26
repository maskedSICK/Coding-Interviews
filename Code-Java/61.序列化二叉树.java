/*
��������Զ������������л�
1.�������л����Ϊstr����ʼΪ��
2.�������������ʱ��������սڵ㣬strĩβ��ӡ�#����
3.���������Ϊ�յĽڵ㣬����ڵ�ֵΪ3����strĩβ��ӡ�3����
ע��㣺
1.#����սڵ㣬ÿ���ڵ����ӽ����������������ӽ���������������壬��12���Ǳ�ʾ1��2����12����
2.��ʲô������ʽ���У���Ҫ��ʲô��ʽ�����л����������л��������л�ʱ��Ҫ�����򴴽���������

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