/*
����һ����������������е�����k�����
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
            if(right == null)  //���k��������ĳ���
                return null;
        }
        while(right.next != null){
            right = right.next;
            left = left.next;
        }
		return left;
    }
}