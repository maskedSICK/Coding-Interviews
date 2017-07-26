/*
һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n����
�����������һ��n����̨���ܹ��ж�����������
f(n) = f(n-1) + f(n-2) + ... +f(1) + 1
f(n) = 2 * f(n-1)
*/
public class Solution {
    public int JumpFloorII(int target) {
        int pre = 1;
        int result = 0;
        if(target <= 0)
            return 0;
        if(target == 1)
            return 1;
        for(int i = 2; i <= target; i++){
            result = 2 * pre;
            pre = result;
        }
        return result;
    }
}