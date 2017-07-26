/*
��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ������磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��

˼�룺������һ��ֻ����һ�ε��ַ���һ��
*/

import java.util.Map;
import java.util.LinkedHashMap;

public class Solution {
    Map<Character, Integer> map = new LinkedHashMap<>();
    
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(map.containsKey(ch)){
            int count = map.get(ch) + 1;
            map.put(ch, count);
        }
        else{
            map.put(ch, 1);
        }
    }
    
  	//return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(char key : map.keySet()){
            if(map.get(key) == 1)
                return key;
        }
    	return '#';
    }
}