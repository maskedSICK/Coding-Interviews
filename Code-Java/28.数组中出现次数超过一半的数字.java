

public class Solution {
	//����1������������ص�
    /*
    public int MoreThanHalfNum_Solution(int[] array) {
        if(array.length == 0)
            return 0;
        int result = array[0];
        int times = 1;
        for(int i = 1; i < array.length; i++){
            if(result == array[i])
                times++;
            else
                times--;
            if(times == 0){
                result = array[i];
                times = 1;
            }
        }
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(result == array[i])
                count++;
        }
        if(count * 2 <= array.length)
            return 0;
        else
            return result;
    }
    */
	//����2�������г��ִ�������һ������������������һ��λ�������м䣬��n/2��
	//     ���ԣ�Ѱ����λ�����ɡ�
	//�����׶ˣ����޸�����
	//���ÿ����е�partition������Ѱ���±�Ϊn/2����
	//(NB:����partition����������o(n)ʱ�����ҵ������k�������)

     public int MoreThanHalfNum_Solution(int[] array) {
         if(array.length == 0)
             return 0;
         int mid = array.length / 2;
         int start = 0;
         int end = array.length - 1;
         int index = partition(array, start, end);
         while(index != mid){
             if(index > mid){
                 end = index - 1;
                 index = partition(array, start, end);
             }
             else{
                 start = index + 1;
                 index = partition(array, start, end);
             }
         }
         int result = array[mid];
         
         int count = 0;
         for(int i = 0; i < array.length; i++){
             if(result == array[i])
                 count++;
         }
         if(count * 2 <= array.length)
             return 0;
         else
             return result;
    }
    
    public int partition(int[] a, int start, int end){
        int index = start;
        swap(a, index, end);
        int small = start;
        for(int i = start; i < end; i++){
            if(a[i] < a[end]){
                if(i != small)
                    swap(a, i, small);
                small++;
            }
        }
        swap(a, small, end);
        return small;
    }
    
    public void swap(int[] a, int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}