/*
思想：返回位置用HashMap
      返回字符用LinkedHashMap
*/

import java.util.Map;
import java.util.HashMap;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str == "")
        	return -1;
        Map<Character, Integer> map = new HashMap<>();
        //遍历字符串
        for(int i = 0; i < str.length(); i++){
            if(map.containsKey(str.charAt(i))){
                int count = map.get(str.charAt(i));
                map.put(str.charAt(i), ++count);
            }
            else
                map.put(str.charAt(i), 1);
        }
        //遍历字符串
        for(int i = 0; i < str.length(); i++){
            if(map.get(str.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}