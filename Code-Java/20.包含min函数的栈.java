/*
定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。

思想：利用辅助栈
*/

import java.util.Stack;

public class Solution {
	Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
  
    public void push(int node) {
        data.push(node);
        if(min.isEmpty()){
            min.push(node);
        }      
        else{
            int temp = min.peek();
            if(node <= temp)
                min.push(node);
            else
                min.push(temp);
        }
    }
    
    public void pop() {
        data.pop();
        min.pop();
    }
    
    public int top() {
        return data.peek();
    }
    
    public int min() {
        return min.peek();
    }
}