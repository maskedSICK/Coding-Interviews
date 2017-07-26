/*
����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
����������Yes,�������No���������������������������ֶ�������ͬ��
*/

public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence == null || sequence.length == 0)
            return false;
        boolean result = isBST(sequence, 0, sequence.length - 1);
        return result;
    }
    
    public boolean isBST(int[] arr, int start, int end){
        if(start >= end)
            return true;
        //�����
        int root = arr[end];
        //������
        int i = start;
        for(; i < end; i++){
            if(arr[i] > root)
                break;
        }
        //������
        int j = i;
        for(; j < end; j++){
            if(arr[j] < root)
                return false;
        }
        //�ݹ�������
        boolean left = isBST(arr, start, i - 1);
        //�ݹ�������
        boolean right = isBST(arr, i, j - 1);
        return left && right;
    }            
}