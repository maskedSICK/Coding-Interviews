/*
����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S��
����ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
*/

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(array.length == 0)
            return list;
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            if((array[left] + array[right]) == sum){
                list.add(array[left]);
                list.add(array[right]);
                break;
            }
            else if((array[left] + array[right]) < sum){
                left++;
            }
            else{
                right--;
            }
        }
        return list;
    }
}