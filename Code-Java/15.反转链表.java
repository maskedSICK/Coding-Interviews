/*
����һ��������ת�����������������Ԫ�ء�
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
    public ListNode ReverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode pre = null, cur = head, next = null, reversedNode = null;
        while(cur != null){
            next = cur.next;
            if(next == null)
                reversedNode = cur;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
		return reversedNode;
    }
}