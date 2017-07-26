/**
* 题目：输入一个字符串，求该字符串的所有排列。
*     如输入字符串abc，则全排列为abc,acb,bac,bca,cab,cba。
* 思路：全排列生成递归算法
*     原则：n个字符的排列=前缀 + n-1个字符的排列
*     1)n个字符依次做前缀
*     2)排列剩下n-1个字符
*     注：排完了不要忘记回溯！！
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        if(str == null || str.length() == 0)
            return list;
        HashSet<String> set = new HashSet<String>(); //用于去重
        char[] strArray = str.toCharArray();
        perm(strArray, 0, str.length() - 1, set);
        list.addAll(set);
        //字典序排列
        Collections.sort(list);
        return list;
    }
    
    public void perm(char[] arr, int start, int end, HashSet<String> set){
        //数组中只剩一个字母
        if(start == end){
            set.add(String.valueOf(arr));
            return;
        }
        //数组中有多个字母
        for(int i = start; i <= end; i++){
            if(i == start || arr[i] != arr[start]){ //arr[i] != arr[start] 这句并不能彻底解决去重的问题，但可以减少运算
                swap(arr, start, i);
                perm(arr, start + 1, end, set);
                swap(arr, start, i);
            }
        }
    }
    
    public void swap(char[] arr, int x, int y){
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}