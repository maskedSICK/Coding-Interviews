/*
��Ŀ�����˿�����������5���ƣ��ж��ǲ���һ��˳�ӣ������������ǲ��������ġ�
2����10Ϊ���ֱ���AΪ1��JΪ11��QΪ12��KΪ13������С��Ϊ�������֡�
������Ҫ��3���£����Ȱ�����������ͳ��������0�ĸ��������ͳ������֮�����������ڵ�����֮��Ŀ�ȱ������
�����ȱ����С�ڻ��ߵ���0�ĸ�������ô���������������ģ���֮��������
������ǻ���Ҫע��һ�㣺��������еķ�0���ַ������֣�������鲻�������ġ�
�����˿��Ƶ�������ʽ�������һ�����ﺬ�ж��ӣ��򲻿�����˳�ӡ�

*/

import java.util.Arrays;

public class Solution {
    public boolean isContinuous(int[] numbers) {
        if(numbers == null || numbers.length == 0)
            return false;
        Arrays.sort(numbers);
        int count0 = 0;
        int countGap = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 0)
                count0++;
            else{
                if(i < numbers.length - 1 && numbers[i] == numbers[i + 1])
                    return false;
                if(i < numbers.length - 1 && (numbers[i + 1] - numbers[i] > 1))
                    countGap += numbers[i + 1] - numbers[i] - 1;
            }
        }
        if(countGap <= count0 && count0 <= 4)
            return true;
		return false;
    }
}