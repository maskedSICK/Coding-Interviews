/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
思想：类似插入排序
*/

public class Solution {
    public void reOrderArray(int[] array) {
        if(array == null && array.length == 0)
            return;
        for(int i = 1; i < array.length; i++){
            for(int j = i; j > 0; j--){
                if(array[j] % 2 != 0 && array[j - 1] % 2 == 0){
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}