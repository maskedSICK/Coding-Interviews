/*
��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
*/

public class Solution {
    public int minNumberInRotateArray(int[] array) {
        int n = array.length;
    	if(array == null && n == 0)
            return 0;
        //ԭʼ��������
        if(array[0] < array[n - 1])
            return array[0];
        //��ת����
        int left = 0, right = n - 1;
        int mid = 0;
        while(left < right){
            //����ֻ������ֵʱ
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