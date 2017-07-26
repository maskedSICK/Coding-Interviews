/*
1������������Ϊż��ʱ���¼����Ԫ�أ�Ӧ������С����
��ע�ⲻ��ֱ�ӽ���С���ѣ����Ǿ������ɸѡ��ȡ����������Ԫ�ؽ���С���ѣ�
2������������Ϊ����ʱ���¼����Ԫ�أ�Ӧ����������
��ע�ⲻ��ֱ�ӽ������ѣ����Ǿ�С����ɸѡ��ȡС���������Ԫ�ؽ������ѣ�
*/

import java.util.PriorityQueue;
import java.util.Comparator;

public class Solution {
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(20, new Comparator<Integer>(){
        @Override
        public int compare(Integer x, Integer y){
            return y - x;
        }
    });

    public void Insert(Integer num) {
    	if(count % 2 == 0){
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            minHeap.offer(filteredMaxNum);
        }
        else{
            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
            maxHeap.offer(filteredMinNum);
        }
        count++;
    }

    public Double GetMedian() {
        if(count % 2 != 0)
         	return new Double(minHeap.peek());
        else
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
    }
}