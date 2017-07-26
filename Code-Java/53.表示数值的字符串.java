/*
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
*/

public class Solution {
    public boolean isNumeric(char[] str) {
        if(str == null)
            return false;
        int index = 0;
        if(str[index] == '+' || str[index] == '-'){
            index++;
            if(index == str.length)
                return false;
        }
        index = scanDigits(str, index);
        if(index == str.length)
            return true;
        if(str[index] == '.'){
            index++;
            if(index == str.length){
                return true;
            }
            index = scanDigits(str, index);
            if(index == str.length)
                return true;
            if(str[index] == 'e' || str[index] == 'E')
                return isE(str, index);
        }
        else{
            if(str[index] == 'e' || str[index] == 'E')
                return isE(str, index);
        }
        return false;
    }
    
    private int scanDigits(char[] str, int index){
        while(index < str.length && str[index] >= '0' && str[index] <= '9'){
            index++;
        }
        return index;
    }
    
    private boolean isE(char[] str, int index){
        if(str[index] == 'e' || str[index] == 'E'){
            index++;
            if(index == str.length)
                return false;
        }
        if(str[index] == '+' || str[index] == '-'){
            index++;
            if(index == str.length)
                return false;
        }
        index = scanDigits(str, index);
        return index == str.length;
    }
    
}