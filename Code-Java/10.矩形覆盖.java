/*
���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
*/
public class Solution {
    public int RectCover(int target) {
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