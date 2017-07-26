/*
����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String PrintMinNumber(int[] numbers) {
        if(numbers == null || numbers.length == 0)
            return "";
        int n = numbers.length;
        String[] str = new String[n];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
            str[i] = String.valueOf(numbers[i]);
        Arrays.sort(str, new Comparator<String>(){

            public int compare(String s1, String s2){
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });
        for(int i = 0; i < n; i++)
            sb.append(str[i]);
        return sb.toString();
    }
}
