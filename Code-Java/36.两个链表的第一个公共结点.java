/*
���ȱ�����������õ����ǵĳ��ȣ�����֪���ĸ�����Ƚϳ����Լ���������ȶ̵�����༸����㡣
�ڵڶ��α�����ʱ���ڽϳ����������������ɲ���������ͬʱ�����������ϱ������ҵ���һ����ͬ�Ľ��������ǵĵ�һ��������㡣
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
    public ListNode FindFirstCommonNode(ListNode head1, ListNode head2) {
        int length1 = getLength(head1);
        int length2 = getLength(head2);
        int diff = length2 - length1;
        ListNode longNode = head2;
        ListNode shortNode = head1;
        if(length1 > length2){
            diff = -diff;
            longNode = head1;
            shortNode = head2;
        }
        for(int i = 0; i < diff; i++){
            longNode = longNode.next;
        }
        while(longNode != null && shortNode != null && longNode != shortNode){
            longNode = longNode.next;
            shortNode = shortNode.next;
        }
 		return longNode;
    }
    
    public int getLength(ListNode head){
        if(head == null)
            return 0;
        int length = 0;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }
}