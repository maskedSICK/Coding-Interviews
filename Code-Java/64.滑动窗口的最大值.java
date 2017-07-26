/* ��Ŀ���������ڵ����ֵ
  ˼·����������Ӧ���Ƕ��У���Ϊ�˵õ��������ڵ����ֵ����������Դ�����ɾ��Ԫ�أ����ʹ��˫�˶��С�
  ԭ��
      ��������Ԫ��k��������˫�˶����е�Ԫ����Ƚ�
      1��ǰ���kС�ģ�ֱ���Ƴ����У���Ϊ���ٿ��ܳ�Ϊ���滬�����ڵ����ֵ��!��, 
	  2��ǰ���k���X���Ƚ������±꣬�ж�X�Ƿ��Ѳ��ڴ���֮�ڣ������ˣ�ֱ���Ƴ�����
      ���еĵ�һ��Ԫ���ǻ��������е����ֵ
*/

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(num == null || num.length == 0 || num.length < size || size < 1)
            return list;
        LinkedList<Integer> dqueue = new LinkedList<>(); //dqueue���������
        //�����ǰsize-1����
        for(int i = 0; i < size - 1; i++){
            while(!dqueue.isEmpty() && num[i] > num[dqueue.getLast()]){
                dqueue.removeLast();
            }
            dqueue.addLast(i);
        }
        for(int i = size - 1; i < num.length; i++){
            while(!dqueue.isEmpty() && num[i] > num[dqueue.getLast()]){
                dqueue.removeLast();
            }
            dqueue.addLast(i);
            if(i - dqueue.getFirst() + 1 > size){
                dqueue.removeFirst();
            }
            list.add(num[dqueue.getFirst()]);
        }
        return list;
    }
}