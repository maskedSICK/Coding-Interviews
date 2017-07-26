/*
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
*/

public class Solution {
    public double Power(double base, int exponent) {
        int absE = 0;
        if(exponent == 0)
            return 1;
        double result = 1;
        if(exponent > 0){
            absE = exponent;            
        }
        if(exponent < 0){
            if(base == 0)
                throw new RuntimeException("分母不能为0"); 
            absE = -exponent;            
        }
        for(int i = 0; i < absE; i++){
            result *= base; 
        }
        if(exponent < 0){
            result = 1.0 / result;
        }
        return result;
    }
}

//递归：n为偶数，a^n=a^n/2*a^n/2;n为奇数，a^n=（a^（n-1）/2）*（a^（n-1/2））*a
//时间复杂度O（logn）
public class Solution {
    public double Power(double base, int exponent) {
        int absE = 0;
        if(exponent == 0)
            return 1;
        if(exponent > 0){
            absE = exponent;            
        }
        if(exponent < 0){
            if(base == 0)
                throw new RuntimeException("分母不能为0"); 
            absE = -exponent;            
        }
        double result = PowerWithUnsignedE(base, absE);
        if(exponent < 0){
            result = 1.0 / result;
        }
        return result;
    }
    
    public double PowerWithUnsignedE(double base, int exponent){
        if(exponent == 0)
            return 1;
        if(exponent == 1)
            return base;
        double result = PowerWithUnsignedE(base, exponent >> 1);
        result *= result;
        if((exponent & 1) == 1)
            result *= base;
        return result;
    }
}