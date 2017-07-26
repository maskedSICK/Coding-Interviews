/*
��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
���磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ�� ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
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