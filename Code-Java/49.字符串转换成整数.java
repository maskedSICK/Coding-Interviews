/*
��������:
����һ���ַ���,����������ĸ����,����Ϊ��


�������:
����ǺϷ�����ֵ����򷵻ظ����֣����򷵻�0

��������:
+2147483647
    1a33

�������:
2147483647
    0
*/

public class Solution {
    public int StrToInt(String str) {
        if(str == null || str.length() ==0)
             return 0;
        str = str.trim();  //ȥ��ǰ��Ŀո�
        int flag = 1;   //������
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
