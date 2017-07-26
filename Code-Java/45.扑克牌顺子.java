/*
题目：从扑克牌中随机抽出5张牌，判断是不是一个顺子，即这五张牌是不是连续的。
2——10为数字本身，A为1，J为11，Q为12，K为13，而大小王为任意数字。
我们需要做3件事：首先把数组排序，再统计数组中0的个数，最后统计排序之后数组中相邻的数字之间的空缺总数。
如果空缺综述小于或者等于0的个数，那么这个数组就是连续的；反之则不连续。
最后我们还需要注意一点：如果数组中的非0数字反复出现，则该数组不是连续的。
换成扑克牌的描述方式就是如果一副牌里含有对子，则不可能是顺子。

*/

import java.util.Arrays;

public class Solution {
    public boolean isContinuous(int[] numbers) {
        if(numbers == null || numbers.length == 0)
            return false;
        Arrays.sort(numbers);
        int count0 = 0;
        int countGap = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 0)
                count0++;
            else{
                if(i < numbers.length - 1 && numbers[i] == numbers[i + 1])
                    return false;
                if(i < numbers.length - 1 && (numbers[i + 1] - numbers[i] > 1))
                    countGap += numbers[i + 1] - numbers[i] - 1;
            }
        }
        if(countGap <= count0 && count0 <= 4)
            return true;
		return false;
    }
}