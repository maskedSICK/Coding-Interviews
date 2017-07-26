/*
输入一个链表，从尾到头打印链表每个节点的值。
思想：利用栈
*/
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
import java.util.Stack;
 
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(listNode == null){
            return list;
        }
        Stack<Integer> stack = new Stack<Integer>();
        ListNode cur = listNode;
        while(cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}