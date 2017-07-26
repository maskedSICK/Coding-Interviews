/*
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
*/
public class Solution {
    public int RectCover(int target) {
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