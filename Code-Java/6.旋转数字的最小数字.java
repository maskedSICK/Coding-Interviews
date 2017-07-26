/*
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
*/

public class Solution {
    public int minNumberInRotateArray(int[] array) {
        int n = array.length;
    	if(array == null && n == 0)
            return 0;
        //原始数组的情况
        if(array[0] < array[n - 1])
            return array[0];
        //旋转数组
        int left = 0, right = n - 1;
        int mid = 0;
        while(left < right){
            //数组只有两个值时
            if(left == right - 1){
                break;
            }
            mid = (left + right) / 2;
            if(array[left] == array[right] && array[mid] == array[left]){
                int min = array[0];
                for(int i = 0; i < n; i++){
                    if(array[i] < min)
                        min = array[i];
                }
                return min;
            }
            if(array[mid] >= array[left]){
                left = mid;
            }
            else if(array[mid] <= array[right]){
                right = mid;
            }
        }
        return Math.min(array[left],array[right]);
    }
}