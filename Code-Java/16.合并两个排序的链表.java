/*
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
思想：递归
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