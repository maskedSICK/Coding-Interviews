/*
例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
*/

public class Solution {
    public String LeftRotateString(String str, int n) {
        if(str == null || str.length() == 0 || n <= 0)
            return str;
        String newStr = reverse(str);
        String lStr = newStr.substring(0, str.length() - n);
        String rStr = newStr.substring(str.length() - n, str.length());
        String result = "";
        result += reverse(lStr) + reverse(rStr);
        return result;
    }
    
    public String reverse(String str){
        char[] charStr = str.toCharArray();
        int n = charStr.length;
        for(int i = 0; i < (n / 2); i++){
            char temp = charStr[i];
            charStr[i] = charStr[n - 1 - i];
            charStr[n - 1 - i] = temp;
        }
        return String.valueOf(charStr);
    }
}