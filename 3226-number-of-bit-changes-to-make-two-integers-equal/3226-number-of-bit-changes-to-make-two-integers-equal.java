class Solution {
    public int minChanges(int n, int k) {
        int temp = n^k;
        int ans = 0;
        for(int i=31; i>-1; i--) {
            if(((temp>>i)&1)==1 && ((n>>i)&1)!=1) {
                return -1;
            }
            ans += (temp>>i)&1;
        }
        return ans;
    }
}

//1101
//0100
//1001

