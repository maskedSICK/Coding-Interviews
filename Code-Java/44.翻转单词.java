/*
¡°student. a am I¡± --->¡°I am a student.¡±
*/

public class Solution {
    public String ReverseSentence(String str) {
        String result = "";
        if(str == null || str.length() == 0 || str.trim().length() == 0)
            return str;
        String rStr = reverse(str);
        String[] word = rStr.split(" ");
        for(int i = 0; i < word.length - 1; i++){
            result += reverse(word[i]) + " ";
        }
        result += reverse(word[word.length - 1]);
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