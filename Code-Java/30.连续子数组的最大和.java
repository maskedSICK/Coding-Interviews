/*
��
*/


public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 0)
            return 0;
        int maxSum = array[0];
        int sum = array[0];
        for(int i = 1; i < array.length; i++){
            if(sum > 0)
            	sum += array[i];  //ֻ�е�sumΪ��ʱ�ż���
            else
                sum = array[i];
            if(sum > maxSum)
                maxSum = sum;
        }
        return maxSum;
    }
}