/*
һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
�����������һ��n����̨���ܹ��ж�����������
*/
public class Solution {
    public int JumpFloor(int target) {
        int preone = 1;
        int pretwo = 2;
        int result = 0;
        if(target <= 0)
            return 0;
        if(target == 1)
            return preone;
        if(target == 2)
            return pretwo;
        for(int i = 3; i <= target; i++){
            result = preone + pretwo;
            preone = pretwo;
            pretwo = result;
        }
        return result;
    }
}