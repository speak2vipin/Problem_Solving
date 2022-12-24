class Solution {
    public int numTilings(int n) {
        if(n==1) {
            return 1;
        } else if(n==2) {
            return 2;
        } else if( n==3) {
            return 5;
        }
        int mod = 1000000007;
        int ans[] = new int[n+1];
        ans[1] = 1;
        ans[2] = 2;
        ans[3] = 5;
        for(int i=4; i<=n; i++) {
            ans[i] = (2*ans[i-1]%mod + ans[i-3]%mod)%mod;
        }
        return ans[n];
    }
}