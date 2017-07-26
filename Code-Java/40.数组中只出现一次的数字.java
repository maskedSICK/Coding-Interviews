/*
一个整型数组里除了两个数字之外，其他的数字都出现了两次。
思想：
我们还是从头到尾依次异或数组中的每一个数字，那么最终得到的结果就是两个只出现一次的数字的异或结果。
 也就是说在这个结果数字的二进制表示中至少就有一位为1 。我们在结果数字中找到第一个为1 的位的位置，记为第N 位（从右数）。
 现在我们以第N位是不是1 为标准把原数组中的数字分成两个子数组，第一个子数组中每个数字的第N 位都为1，
 而第二个子数组的每个数字的第N 位都为0。
*/

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if(array == null || array.length == 0)
            return;
        int result = 0;
        for(int i = 0; i < array.length; i++)
            result ^= array[i];
        int index = firstBitIs1(result);
        for(int i = 0; i < array.length; i++){
            if(isBit1(array[i], index)){
                num1[0] ^= array[i];
            }
            else{
                num2[0] ^= array[i];
            }
        }
    }
    
    public int firstBitIs1(int a){
        int index = 0;
        while((a & 1) == 0){
            a = a >> 1;
            index++;
        }
        return index;
    }
    
    public boolean isBit1(int a, int index){
        a = a >> index;
        if((a & 1) == 0)
            return false;
        return true;
    }
}