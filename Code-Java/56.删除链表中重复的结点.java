/*
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

注意细节！！
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
        ListNode myHead = new ListNode(-1);  //创建一个头结点
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
                if(q == null){   //根据q.next == null 跳出上面的循环
                    p.next = null;
                    break;
                }
                if(q.next == null) //根据q.val != q.next.val 跳出上面的循环
                    p.next = q;
            }
        }
        return myHead.next;
    }
}