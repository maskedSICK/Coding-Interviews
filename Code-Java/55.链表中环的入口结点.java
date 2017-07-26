/*
���Ž�ʱ�临�Ӷ�ΪO��N�����ռ临�Ӷ�ΪO��1��
1.�ж��л�
�������ָ��slow��fast����slow=head��fast=head��
slowÿ����һ����fastÿ����������
�������޻���fast���ܿ�Ϊnull�����ؿռ��ɡ�
�������л���slow��fast���ڻ��е�ĳ��λ������
2.�л�ʱ��
fast�ٴδ�ͷ������ÿ����һ����
slow�������������ÿ����һ����
�ٴ�������Ϊ����ڵ㡣
��ͷ�ڵ㵽����ڵ�ľ���=�����㵽����ڵ�ľ��룩

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

    public ListNode EntryNodeOfLoop(ListNode head)
    {
        if(head == null || head.next == null)
            return null;
        boolean circle = false;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                circle = true;
                break;
            }
        }
        if(circle == false)
            return null;
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}