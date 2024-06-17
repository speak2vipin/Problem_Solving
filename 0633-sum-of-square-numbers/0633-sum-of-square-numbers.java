class Solution {
    public boolean judgeSquareSum(int c) {
        for(int i=0; i<=Math.sqrt(c); i++) {
            int x = c - i*i;
            int temp = (int)Math.sqrt(x);
            if(x == temp * temp) {
                return true;
            }
        }
        return false;
    }
}