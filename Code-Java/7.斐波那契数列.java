/*
��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n�
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