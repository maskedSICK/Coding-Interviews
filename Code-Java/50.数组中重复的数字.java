/*
此大法利用了哈希的特性，但不需要额外的存储空间。 因此时间复杂度为O(n)，不需要额外空间！

1、把当前序列当成是一个下标和下标对应值是相同的数组；
2、遍历数组，判断当前位的值和下标是否相等：  
	2.1. 若相等，则遍历下一位；  
	2.2. 若不等，则将当前位置i上的元素和a[i]位置上的元素比较：若它们相等，则成功！若不等，则将它们两交换。
		换完之后a[i]位置上的值和它的下标是对应的，但i位置上的元素和下标并不一定对应；
		重复2.2的操作，直到当前位置i的值也为i，将i向后移一位，再重复2.
*/

public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        if(numbers == null || length == 0)
            return false;
        for(int i = 0; i < length; i++){
            if(numbers[i] < 0 || numbers[i] >= length)
                return false;
        }
        for(int i = 0; i < length; i++){
            while(numbers[i] != i){
                if(numbers[numbers[i]] == numbers[i]){
                    duplication[0] = numbers[i];
                    return true;
                }
                else
                    swap(numbers, i, numbers[i]);
                }
        }
        return false;
    }
    
    public void swap(int[] a, int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}