/*
输入一个链表，输出该链表中倒数第k个结点
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
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head == null || k == 0)
            return null;
        ListNode left = head, right = head;
        for(int i = 0; i < k - 1; i++){
            right = right.next;
            if(right == null)  //如果k大于链表的长度
                return null;
        }
        while(right.next != null){
            right = right.next;
            left = left.next;
        }
		return left;
    }
}