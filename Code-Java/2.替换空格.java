/*
��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20����
���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
*/
public class Solution {
    public String replaceSpace(StringBuffer str) {
    	if(str == null)
            return null;
        StringBuffer newStr = new StringBuffer();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ' '){
                newStr.append(str.charAt(i));
            }
            else{                
                newStr.append("%20");
            }
        }
        return newStr.toString();
    }
}