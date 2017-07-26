/*
输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
*/

import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
       	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(sum <= 0)
            return list;
        int left = 1;
        int right = 2;
        int curSum = left + right;
        while(left <= sum / 2){
            if(curSum == sum){
                ArrayList<Integer> list1 = new ArrayList<Integer>();
                for(int i = left; i <= right; i++){
                    list1.add(i);
                }
                list.add(list1);
                right++;
                curSum += right;
            }
            else if(curSum < sum){
                right++;
                curSum += right;
            }
            else{
                curSum -= left;
                left++;
            }
        }
        return list;
    }
}