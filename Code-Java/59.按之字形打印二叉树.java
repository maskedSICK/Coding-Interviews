
/**
* ��ҵ�ʵ�ֺܶ඼�ǽ�ÿ������ݴ��ArrayList�У�ż����ʱ����reverse�������ں�������ʱ������Ч��̫���ˡ�
* ������һ�����ԣ��㷨���ľ���֮���δ�ӡ������������reverse��ֱ�ӱ������ˣ����Թ�˵��������ʱЧ�ʸ����Ͳ��С���
* 
* �����ʵ�֣����ؽ�ÿ������ݴ��ArrayList�У�ż����ʱ����reverse������ֱ�Ӱ���ӡ˳�����
* ˼·������Java�е�LinkedList�ĵײ�ʵ����˫��������ص㡣
* 1)����������,ʵ�����Ĳ�α���
* 2)��˫�����,������ʱ��ǰ��������ż����ʱ�Ӻ���ǰ����
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

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
    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return list;
        ArrayList<Integer> list1 = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(null);
        queue.addLast(root);
        boolean leftToRight = true;
        while(queue.size() > 1){
            TreeNode node = queue.removeFirst();
            if(node == null){ //����ָ���
                Iterator iter = null;
                if(leftToRight){
                    iter = queue.iterator();//��ǰ�������
                }
                else{
                    iter = queue.descendingIterator();//�Ӻ���ǰ����
                }
                leftToRight = !leftToRight;
                while(iter.hasNext()){
                    TreeNode temp = (TreeNode)iter.next();
                    list1.add(temp.val);
                }
                list.add(list1);
                list1 = new ArrayList<>();
                queue.addLast(null);   //��Ӳ�ָ���
                continue;
            }
            if(node.left != null)
                queue.addLast(node.left);
            if(node.right != null)
                queue.addLast(node.right);
            
        }
        return list;
    }

}