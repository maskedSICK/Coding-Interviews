/*
����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
���ؽ��Ϊ���ƺ��������head��
��ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
*/

/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode head)
    {
        if(head == null)
            return null;
        clone(head);
        return separate(head);
    }
    
    public void clone(RandomListNode head){
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode cloneNode = new RandomListNode(cur.label);
            RandomListNode next = cur.next;
            cur.next = cloneNode;
            cloneNode.next = next;
            cur = next;
        }
        cur = head;
        while(cur != null){
            if(cur.random != null)
            	cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
    }
    
    public RandomListNode separate(RandomListNode head){
        RandomListNode cur = head;
        RandomListNode clonedHead = null;
        RandomListNode clonedNode = null;
        if(cur != null){
            clonedHead = head.next;
            clonedNode = clonedHead;
            cur.next = clonedNode.next;
        	cur = cur.next;
        }
        while(cur != null){
            clonedNode.next = cur.next;
            clonedNode = clonedNode.next;
            cur.next = clonedNode.next;
            cur = cur.next;
        }
        return clonedHead;
    }
}