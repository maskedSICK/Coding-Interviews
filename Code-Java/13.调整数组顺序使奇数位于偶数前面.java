/*
����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
���е�ż��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
˼�룺���Ʋ�������
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