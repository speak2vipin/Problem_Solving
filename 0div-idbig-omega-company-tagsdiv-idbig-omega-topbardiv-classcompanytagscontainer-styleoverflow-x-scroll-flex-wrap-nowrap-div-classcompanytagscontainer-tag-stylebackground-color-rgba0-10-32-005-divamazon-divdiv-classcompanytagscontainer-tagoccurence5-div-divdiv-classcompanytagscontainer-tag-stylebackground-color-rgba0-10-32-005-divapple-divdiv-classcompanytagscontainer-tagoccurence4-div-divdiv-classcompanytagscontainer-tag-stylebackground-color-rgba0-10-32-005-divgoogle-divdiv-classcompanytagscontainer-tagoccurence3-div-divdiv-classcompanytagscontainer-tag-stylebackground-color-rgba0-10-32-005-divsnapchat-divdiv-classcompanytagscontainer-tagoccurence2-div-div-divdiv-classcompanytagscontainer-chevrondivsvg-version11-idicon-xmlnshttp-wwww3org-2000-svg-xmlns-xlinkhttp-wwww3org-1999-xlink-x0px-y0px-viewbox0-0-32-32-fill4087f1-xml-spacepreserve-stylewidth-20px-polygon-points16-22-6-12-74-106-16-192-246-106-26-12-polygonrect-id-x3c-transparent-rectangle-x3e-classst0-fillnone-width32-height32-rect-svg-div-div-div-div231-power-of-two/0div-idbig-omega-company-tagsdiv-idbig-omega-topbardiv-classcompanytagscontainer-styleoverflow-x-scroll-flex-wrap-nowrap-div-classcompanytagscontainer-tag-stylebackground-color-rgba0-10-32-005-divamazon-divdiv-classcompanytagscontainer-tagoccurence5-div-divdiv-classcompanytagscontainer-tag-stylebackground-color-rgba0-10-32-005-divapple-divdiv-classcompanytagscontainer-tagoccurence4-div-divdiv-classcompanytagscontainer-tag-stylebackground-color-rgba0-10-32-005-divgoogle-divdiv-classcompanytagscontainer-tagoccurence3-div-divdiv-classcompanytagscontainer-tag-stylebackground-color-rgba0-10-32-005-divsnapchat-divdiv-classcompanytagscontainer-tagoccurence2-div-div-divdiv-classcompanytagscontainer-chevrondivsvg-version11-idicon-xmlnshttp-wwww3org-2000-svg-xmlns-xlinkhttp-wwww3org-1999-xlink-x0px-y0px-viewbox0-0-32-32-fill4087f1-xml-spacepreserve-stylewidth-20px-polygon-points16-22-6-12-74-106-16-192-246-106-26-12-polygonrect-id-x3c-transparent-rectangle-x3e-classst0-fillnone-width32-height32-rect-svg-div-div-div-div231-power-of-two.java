class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<0) {
            return false;
        }
        int count = 0;
        for(int i=31; i>-1; i--) {
            if(((n>>i)&1)==1) {
                count++;
            }
        }
        return count==1?true:false;
    }
}