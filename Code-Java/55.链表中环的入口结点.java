/*
最优解时间复杂度为O（N），空间复杂度为O（1）
1.判断有环
定义快慢指针slow，fast，（slow=head，fast=head）
slow每次走一步，fast每次走两步。
若链表无环，fast将很快为null，返回空即可。
若链表有环，slow，fast将在环中的某个位置相遇
2.有环时，
fast再次从头出发，每次走一步，
slow从相遇点出发，每次走一步，
再次相遇即为环入口点。
（头节点到环入口点的距离=相遇点到环入口点的距离）

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