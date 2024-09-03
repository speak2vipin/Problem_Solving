class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int res = 0;
        int count = 4;
        int factor = 1;
        while(count>0) {
            int digit = Math.min(num1%10, Math.min(num2%10, num3%10));
            num1 = num1/10;
            num2 = num2/10;
            num3 = num3/10;
            res += factor*digit;
            factor = factor*10;
            count--;
        }
        return res;
    }
}