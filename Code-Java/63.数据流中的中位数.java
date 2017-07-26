/*
1、当数据总数为偶数时，新加入的元素，应当进入小根堆
（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
2、当数据总数为奇数时，新加入的元素，应当进入大根堆
（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
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