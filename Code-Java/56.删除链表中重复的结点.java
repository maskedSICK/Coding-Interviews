/*
��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣 
���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5

ע��ϸ�ڣ���
*/

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode head)
    {
        if(head == null)
            return null;
        ListNode myHead = new ListNode(-1);  //����һ��ͷ���
        if(head.val == -1)
            myHead.val = -2;
        myHead.next = head;
        ListNode p = myHead;
        ListNode q = head;
        while(q.next != null){
            if(q.val != q.next.val){
                p.next = q;
                p = p.next;
                q = q.next;
            }
            else{
                while(q.next != null && q.val == q.next.val){
                    q = q.next;
                }
                q = q.next;
                if(q == null){   //����q.next == null ���������ѭ��
                    p.next = null;
                    break;
                }
                if(q.next == null) //����q.val != q.next.val ���������ѭ��
                    p.next = q;
            }
        }
        return myHead.next;
    }
}