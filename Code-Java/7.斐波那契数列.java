/*
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
n<=39
*/
public class Solution {
    public int Fibonacci(int n) {
        int preone = 0;
        int pretwo = 1;
        int result = 0;
        if(n <= 0)
            return preone;
		if(n == 1)
            return pretwo;
        for(int i = 2; i <= n; i++){
            result = preone + pretwo;
            preone = pretwo;
            pretwo = result;
        }
        return result;
    }
}