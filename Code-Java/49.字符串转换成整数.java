/*
输入描述:
输入一个字符串,包括数字字母符号,可以为空


输出描述:
如果是合法的数值表达则返回该数字，否则返回0

输入例子:
+2147483647
    1a33

输出例子:
2147483647
    0
*/

public class Solution {
    public int StrToInt(String str) {
        if(str == null || str.length() ==0)
             return 0;
        str = str.trim();  //去掉前后的空格
        int flag = 1;   //正负号
        if(str.charAt(0) == '+'){
            str = str.substring(1, str.length());
        }
        else if(str.charAt(0) == '-'){
            str = str.substring(1, str.length());
            flag = -1;
        }
        long num = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                num = num * 10 + (str.charAt(i) - '0');
                if(flag == 1 && num > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                if(flag == -1 && num > Integer.MAX_VALUE)
                    return Integer.MIN_VALUE;
            }
            else{
                return 0;
            }
        }
        return (int)(flag * num);
    }
}
