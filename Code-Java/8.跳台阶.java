/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级。
求该青蛙跳上一个n级的台阶总共有多少种跳法。
*/
public class Solution {
    public int JumpFloor(int target) {
        int preone = 1;
        int pretwo = 2;
        int result = 0;
        if(target <= 0)
            return 0;
        if(target == 1)
            return preone;
        if(target == 2)
            return pretwo;
        for(int i = 3; i <= target; i++){
            result = preone + pretwo;
            preone = pretwo;
            pretwo = result;
        }
        return result;
    }
}