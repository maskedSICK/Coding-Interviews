/*
题目：0，1，，，，，n-1这n 个数字排成一个圆圈，从数字0开始每次从这个圆圈中删除第m个数字。求出这个圆圈里剩下的最后一个数字。
例如，0，1，2，3，4这5个数字组成的一个圆圈，从数字0开始每次删除第3个数字，则删除的前四个数字依次是2，0，4，1因此最后剩下的数字是3.

*/

import java.util.List;
import java.util.LinkedList;

public class Solution {
    /*
    public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1)
            return -1;
        if(n == 1)
            return 0;
        else
            return (LastRemaining_Solution(n - 1, m) + m) % n;
    }
    */
    public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1)
            return -1;
        int[] a = new int[n]; //用数组模拟环
        int count = n;   //环还剩几个元素
        int step = 0;    //从0到m计数
        int i = -1;   
        while(count > 0){
            i++;
            if(i == n)
                i = 0;   //构成环
            if(a[i] == -1)
                continue;
            step++;
            if(step == m){
                a[i] = -1;
                step = 0;
                count--;
            }
        }
        return i;
    }
    
}