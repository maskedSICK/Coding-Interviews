/*
����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
���磬����������¾��� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
*/

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
       if(matrix == null || m == 0)
           return null;
       ArrayList<Integer> list = new ArrayList<Integer>();
       int circle = (Math.min(m, n) - 1) / 2 + 1;  //ѭ����Ȧ��
       for(int i = 0; i < circle; i++){
           for(int j = i; j <= n - i - 1; j++)
               list.add(matrix[i][j]);
           for(int j = i + 1; j <= m - i - 1; j++)
               list.add(matrix[j][n - i - 1]);
           for(int j = n - i - 2; (j >= i) && (m - i - 1 != i); j--)
               list.add(matrix[m - i - 1][j]);
           for(int j = m - i - 2; j >= i + 1 && (n - i - 1) != i; j--)
               list.add(matrix[j][i]);
       }
        return list;
    }
}