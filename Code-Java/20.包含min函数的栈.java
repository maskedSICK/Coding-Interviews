/*
����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������

˼�룺���ø���ջ
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