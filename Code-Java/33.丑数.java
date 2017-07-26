/*
思想：每次找刚好大于当前最大丑数的M2, M3, M5
*/

public class Solution {
    public int GetUglyNumber_Solution(int n) {
        if(n <= 0)
            return 0;
        int[] uglyArr = new int[n];
        uglyArr[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int count = 1;
        while(count < n){
            int min = min(2 * uglyArr[index2], 3 * uglyArr[index3], 5 * uglyArr[index5]);
            uglyArr[count] = min;
            while(2 * uglyArr[index2] <= uglyArr[count])
                index2++;
            while(3 * uglyArr[index3] <= uglyArr[count])
                index3++;
            while(5 * uglyArr[index5] <= uglyArr[count])
                index5++;
            count++;
        }
        return uglyArr[n - 1];
    }
    
    public int min(int x, int y, int z){
        int min = x < y ? x : y;
        min = min < z ? min : z;
        return min;
    }
}