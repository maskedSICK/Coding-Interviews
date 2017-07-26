/*
Ë¼Ïë£º¹é²¢ÅÅÐò
*/

public class Solution {
    public int InversePairs(int[] array) {
        if(array == null || array.length == 0)
            return 0;
        int n = array.length;
        int result = sort(array, 0, n - 1);
        return result;
    }
    
    public int sort(int[] array, int low, int high){
        if(low == high)
            return 0;
        int mid = (low + high) >> 1;
        int leftCount = sort(array, low, mid);
        int rightCount = sort(array, mid + 1, high);
        int count = merge(array, low, mid, high);
        return (leftCount + rightCount + count) % 1000000007;
    }
    
    public int merge(int[] a, int low, int mid, int high){
        int[] temp = new int[high - low + 1];
        int i = mid;
        int j = high;
        int k = high - low;
        int count = 0;
        while(i >= low && j > mid){
            if(a[i] > a[j]){
                count += (j - mid);
                temp[k--] = a[i--];
                if(count >= 1000000007)
                    count %= 1000000007;
            }
            else{
                temp[k--] = a[j--];
            }
        }
        for(; i >= low; i--)
            temp[k--] = a[i];
        for(; j > mid; j--)
            temp[k--] = a[j];
        for(int s = 0; s < temp.length; s++)
            a[low + s] = temp[s];
        return count;
    }
}

