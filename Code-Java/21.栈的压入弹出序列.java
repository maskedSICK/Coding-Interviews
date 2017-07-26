/*
���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳������4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С�
��ע�⣺���������еĳ�������ȵģ�
*/

import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if(pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0, j = 0;
        stack.push(pushA[i]);
        while(!stack.isEmpty()){
            if(stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
            else if(i >= pushA.length){
                return false;
            }
            i++;
            if(i < pushA.length)
            	stack.push(pushA[i]);
        }
        return true;
    }
}