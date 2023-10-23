class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==0) {
            return false;
        }
        int count = 0;
        long temp = 1;
        while(temp<n) {
            temp = (long)Math.pow(4,count++);
        }
        return temp == n;
    }
}