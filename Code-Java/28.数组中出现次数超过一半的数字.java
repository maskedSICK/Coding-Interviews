

public class Solution {
	//方法1：利用数组的特点
    /*
    public int MoreThanHalfNum_Solution(int[] array) {
        if(array.length == 0)
            return 0;
        int result = array[0];
        int times = 1;
        for(int i = 1; i < array.length; i++){
            if(result == array[i])
                times++;
            else
                times--;
            if(times == 0){
                result = array[i];
                times = 1;
            }
        }
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(result == array[i])
                count++;
        }
        if(count * 2 <= array.length)
            return 0;
        else
            return result;
    }
    */
	//方法2：数组中出现次数超过一半的数，在数组排序后，一定位于数组中间，即n/2处
	//     所以，寻找中位数即可。
	//方法弊端：会修改数组
	//利用快排中的partition函数，寻找下标为n/2的数
	//(NB:利用partition函数可以在o(n)时间内找到任意第k大的数字)

     public int MoreThanHalfNum_Solution(int[] array) {
         if(array.length == 0)
             return 0;
         int mid = array.length / 2;
         int start = 0;
         int end = array.length - 1;
         int index = partition(array, start, end);
         while(index != mid){
             if(index > mid){
                 end = index - 1;
                 index = partition(array, start, end);
             }
             else{
                 start = index + 1;
                 index = partition(array, start, end);
             }
         }
         int result = array[mid];
         
         int count = 0;
         for(int i = 0; i < array.length; i++){
             if(result == array[i])
                 count++;
         }
         if(count * 2 <= array.length)
             return 0;
         else
             return result;
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