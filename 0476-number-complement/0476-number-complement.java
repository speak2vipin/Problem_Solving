class Solution {
    public int findComplement(int num) {
        int ans = 0;
        boolean one = false;
        for(int i=31; i>-1; i--) {
            if(((num>>i)&1)==1) {
                one = true;
            }
            if(one && ((num>>i)&1)==0) {
                ans += 1<<i;
            }
        }
        return ans;
    }
}