/*
�˴������˹�ϣ�����ԣ�������Ҫ����Ĵ洢�ռ䡣 ���ʱ�临�Ӷ�ΪO(n)������Ҫ����ռ䣡

1���ѵ�ǰ���е�����һ���±���±��Ӧֵ����ͬ�����飻
2���������飬�жϵ�ǰλ��ֵ���±��Ƿ���ȣ�  
	2.1. ����ȣ��������һλ��  
	2.2. �����ȣ��򽫵�ǰλ��i�ϵ�Ԫ�غ�a[i]λ���ϵ�Ԫ�رȽϣ���������ȣ���ɹ��������ȣ���������������
		����֮��a[i]λ���ϵ�ֵ�������±��Ƕ�Ӧ�ģ���iλ���ϵ�Ԫ�غ��±겢��һ����Ӧ��
		�ظ�2.2�Ĳ�����ֱ����ǰλ��i��ֵҲΪi����i�����һλ�����ظ�2.
*/

public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
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