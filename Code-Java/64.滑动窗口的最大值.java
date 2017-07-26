/* 题目：滑动窗口的最大值
  思路：滑动窗口应当是队列，但为了得到滑动窗口的最大值，队列序可以从两端删除元素，因此使用双端队列。
  原则：
      对新来的元素k，将其与双端队列中的元素相比较
      1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）, 
	  2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
      队列的第一个元素是滑动窗口中的最大值
*/

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(num == null || num.length == 0 || num.length < size || size < 1)
            return list;
        LinkedList<Integer> dqueue = new LinkedList<>(); //dqueue存的是索引
        //数组的前size-1个数
        for(int i = 0; i < size - 1; i++){
            while(!dqueue.isEmpty() && num[i] > num[dqueue.getLast()]){
                dqueue.removeLast();
            }
            dqueue.addLast(i);
        }
        for(int i = size - 1; i < num.length; i++){
            while(!dqueue.isEmpty() && num[i] > num[dqueue.getLast()]){
                dqueue.removeLast();
            }
            dqueue.addLast(i);
            if(i - dqueue.getFirst() + 1 > size){
                dqueue.removeFirst();
            }
            list.add(num[dqueue.getFirst()]);
        }
        return list;
    }
}