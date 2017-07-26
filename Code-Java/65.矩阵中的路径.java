/*
�ڱ����У�Ҳ���ǳ�����matrix���������е���Ϊ���ķ�����Ȼ�����������������ĸ�����ĵݹ飻
�ڵݹ��У���������Ŀ�Ļ��Զ���ջ�ص���һ��״̬��
*/

public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        int[] flag = new int[matrix.length];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(helper(matrix, rows, cols, str, i, j, 0, flag))
                    return true;
            }
        }
        return false;
    }
	
    public boolean helper(char[] matrix, int rows, int cols, char[] str, int i, int j, int k, int[] flag){
        //��Ϊ��һά�����Ŷ�ά��ֵ��indexֵ�����൱�ڶ�ά����ģ�i��j����һά������±�
        int index = i * cols + j;
        //flag[index]==true,˵�������ʹ��ˣ���ôҲ����true;
        if(i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
            return false;
        //�ַ����Ѿ����ҽ�����˵���ҵ���·����
        if(k == str.length - 1)
            return true;
        //��Ƿ��ʹ�
        flag[index] = 1;
        //���ĸ�������еݹ����,�������ң����ϣ����²���
        if(helper(matrix, rows, cols, str, i - 1, j, k + 1, flag)
          || helper(matrix, rows, cols, str, i + 1, j, k + 1, flag)
          || helper(matrix, rows, cols, str, i, j - 1, k + 1, flag)
          || helper(matrix, rows, cols, str, i, j + 1, k + 1, flag))
            return true;
        flag[index] = 0;
        return false;
    }

}