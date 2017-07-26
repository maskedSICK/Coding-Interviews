/*
统计一个数字在排序数组中出现的次数。
思想：二分查找
找到数字在数组中出现的最左出现的位置和最右出现的位置，出现的次数很容易就出来了。
求最左最右出现的位置的思路参考牛客BAT算法的二分查找章节
*/

public class Solution {
    public int GetNumberOfK(int[] array , int k) {
        if(array == null || array.length == 0)
            return 0;
        int firstIndex = getFirst(array, k, 0, array.length - 1);
        int lastIndex = getLast(array, k, 0, array.length - 1);
        if(firstIndex == -1 || lastIndex == -1)
            return 0;
        return (lastIndex - firstIndex + 1);
    }
    
    public int getFirst(int[] a, int k, int low, int high){
        int result = -1;
       	while(low <= high){
            int mid = (low + high) >> 1;
            if(a[mid] == k){
                result = mid;
                high = mid - 1;
            }
            else if(a[mid] > k){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return result;
    }
    
    public int getLast(int[] a, int k, int low, int high){
        int result = -1;
       	while(low <= high){
            int mid = (low + high) >> 1;
            if(a[mid] == k){
                result = mid;
                low = mid + 1;
            }
            else if(a[mid] > k){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return result;
    }
}