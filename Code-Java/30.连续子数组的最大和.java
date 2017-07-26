/*
简单
*/


public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 0)
            return 0;
        int maxSum = array[0];
        int sum = array[0];
        for(int i = 1; i < array.length; i++){
            if(sum > 0)
            	sum += array[i];  //只有当sum为正时才加上
            else
                sum = array[i];
            if(sum > maxSum)
                maxSum = sum;
        }
        return maxSum;
    }
}