/*
����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��

˼�룺���ֺ���
*/

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(input.length < k || k == 0){
            return list;
        }
        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        while(index != k - 1){
            if(index < k - 1){
                start = index + 1;
                index = partition(input, start, end);
            }
            else{
                end = index - 1;
                index = partition(input, start, end);
            }
        }
        for(int i = 0; i <= index; i++){
            list.add(input[i]);
        }
        return list;
    }
    
    public int partition(int[] a, int start, int end){
        int index = start;
        swap(a, index, end);
        int small = start;
        for(int i = start; i < end; i++){
            if(a[i] < a[end]){
                if(i != small)
                    swap(a, i, small);
                small++;
            }
        }
        swap(a, small, end);
        return small;
    }
    
    public void swap(int[] a, int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}