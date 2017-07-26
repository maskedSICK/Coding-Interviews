/*
���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
˼�룺�ݹ�
*/

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;       
        else if(list2 == null)
            return list1;
        ListNode cur1 = list1, cur2 = list2;
        ListNode head = null;
        if(cur1.val <= cur2.val){
            head = cur1;
            head.next = Merge(cur1.next, cur2);
        }
        else{
            head = cur2;
            head.next = Merge(cur1, cur2.next);
        }
        
        return head;
    }
}