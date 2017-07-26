/*
��Ŀ��0��1����������n-1��n �������ų�һ��ԲȦ��������0��ʼÿ�δ����ԲȦ��ɾ����m�����֡�������ԲȦ��ʣ�µ����һ�����֡�
���磬0��1��2��3��4��5��������ɵ�һ��ԲȦ��������0��ʼÿ��ɾ����3�����֣���ɾ����ǰ�ĸ�����������2��0��4��1������ʣ�µ�������3.

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
        int[] a = new int[n]; //������ģ�⻷
        int count = n;   //����ʣ����Ԫ��
        int step = 0;    //��0��m����
        int i = -1;   
        while(count > 0){
            i++;
            if(i == n)
                i = 0;   //���ɻ�
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