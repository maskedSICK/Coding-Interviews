/*
在本题中，也就是尝试了matrix矩阵中所有点作为起点的方法，然后依据这个点进行向四个方向的递归；
在递归中，不满足题目的会自动出栈回到上一个状态；
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
        //因为是一维数组存放二维的值，index值就是相当于二维数组的（i，j）在一维数组的下标
        int index = i * cols + j;
        //flag[index]==true,说明被访问过了，那么也返回true;
        if(i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
            return false;
        //字符串已经查找结束，说明找到该路径了
        if(k == str.length - 1)
            return true;
        //标记访问过
        flag[index] = 1;
        //向四个方向进行递归查找,向左，向右，向上，向下查找
        if(helper(matrix, rows, cols, str, i - 1, j, k + 1, flag)
          || helper(matrix, rows, cols, str, i + 1, j, k + 1, flag)
          || helper(matrix, rows, cols, str, i, j - 1, k + 1, flag)
          || helper(matrix, rows, cols, str, i, j + 1, k + 1, flag))
            return true;
        flag[index] = 0;
        return false;
    }

}