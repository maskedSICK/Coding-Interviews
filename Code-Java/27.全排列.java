/**
* ��Ŀ������һ���ַ���������ַ������������С�
*     �������ַ���abc����ȫ����Ϊabc,acb,bac,bca,cab,cba��
* ˼·��ȫ�������ɵݹ��㷨
*     ԭ��n���ַ�������=ǰ׺ + n-1���ַ�������
*     1)n���ַ�������ǰ׺
*     2)����ʣ��n-1���ַ�
*     ע�������˲�Ҫ���ǻ��ݣ���
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        if(str == null || str.length() == 0)
            return list;
        HashSet<String> set = new HashSet<String>(); //����ȥ��
        char[] strArray = str.toCharArray();
        perm(strArray, 0, str.length() - 1, set);
        list.addAll(set);
        //�ֵ�������
        Collections.sort(list);
        return list;
    }
    
    public void perm(char[] arr, int start, int end, HashSet<String> set){
        //������ֻʣһ����ĸ
        if(start == end){
            set.add(String.valueOf(arr));
            return;
        }
        //�������ж����ĸ
        for(int i = start; i <= end; i++){
            if(i == start || arr[i] != arr[start]){ //arr[i] != arr[start] ��䲢���ܳ��׽��ȥ�ص����⣬�����Լ�������
                swap(arr, start, i);
                perm(arr, start + 1, end, set);
                swap(arr, start, i);
            }
        }
    }
    
    public void swap(char[] arr, int x, int y){
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}