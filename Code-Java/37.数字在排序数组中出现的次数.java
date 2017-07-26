/*
ͳ��һ�����������������г��ֵĴ�����
˼�룺���ֲ���
�ҵ������������г��ֵ�������ֵ�λ�ú����ҳ��ֵ�λ�ã����ֵĴ��������׾ͳ����ˡ�
���������ҳ��ֵ�λ�õ�˼·�ο�ţ��BAT�㷨�Ķ��ֲ����½�
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