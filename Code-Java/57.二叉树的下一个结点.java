/*
����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
˼·��
��1�� ���ýڵ����������������һ���ڵ�Ϊ�����������ӽڵ㣨��ͼ�ڵ� B ��
��2�� ���ýڵ㲻��������������ʱ�����������
2.1 �ýڵ�Ϊ���ڵ�����ӽڵ㣬����һ���ڵ�Ϊ�丸�ڵ㣨��ͼ�ڵ� D ��
2.2 �ýڵ�Ϊ���ڵ�����ӽڵ㣬�����Ÿ��ڵ����ϱ�����ֱ���ҵ�һ���ڵ�ĸ��ڵ�����ӽڵ�Ϊ�ýڵ㣬
��ýڵ�ĸ��ڵ�Ϊ��һ���ڵ㣨��ͼ�ڵ� I �����Ÿ��ڵ�һֱ���ϲ����ҵ� B �� B Ϊ�丸�ڵ�����ӽڵ㣩���� B �ĸ��ڵ� A Ϊ��һ���ڵ㣩��
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
        //���������ģ���ô����������������Ľ��
        if(node.right != null){ 
            node = node.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }
        //����������
        //node�Ǹ���������
        if(node.next != null && node.next.left == node)
            return node.next;
        //node�Ǹ������Һ���
        while(node.next != null){
            if(node.next.left == node)
                return node.next;
            node = node.next;
        }
        return null;
    }
}