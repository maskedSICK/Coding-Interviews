/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
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
        //根结点
        int root = arr[end];
        //左子树
        int i = start;
        for(; i < end; i++){
            if(arr[i] > root)
                break;
        }
        //右子树
        int j = i;
        for(; j < end; j++){
            if(arr[j] < root)
                return false;
        }
        //递归左子树
        boolean left = isBST(arr, start, i - 1);
        //递归右子树
        boolean right = isBST(arr, i, j - 1);
        return left && right;
    }            
}