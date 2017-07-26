/*
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
返回结果为复制后复杂链表的head。
（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
*/

/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode head)
    {
        if(head == null)
            return null;
        clone(head);
        return separate(head);
    }
    
    public void clone(RandomListNode head){
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode cloneNode = new RandomListNode(cur.label);
            RandomListNode next = cur.next;
            cur.next = cloneNode;
            cloneNode.next = next;
            cur = next;
        }
        cur = head;
        while(cur != null){
            if(cur.random != null)
            	cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
    }
    
    public RandomListNode separate(RandomListNode head){
        RandomListNode cur = head;
        RandomListNode clonedHead = null;
        RandomListNode clonedNode = null;
        if(cur != null){
            clonedHead = head.next;
            clonedNode = clonedHead;
            cur.next = clonedNode.next;
        	cur = cur.next;
        }
        while(cur != null){
            clonedNode.next = cur.next;
            clonedNode = clonedNode.next;
            cur.next = clonedNode.next;
            cur = cur.next;
        }
        return clonedHead;
    }
}