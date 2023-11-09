class Solution {
    public int countHomogenous(String s) {
        int mod = 1000_000_007;
        int n = s.length();
        int ans = 0;
        for(int i=0; i<n; ) {
            int j = i;
            if(s.charAt(i)==s.charAt(j)) {
                int count = 1;
                while(j<n && s.charAt(i)==s.charAt(j)) {
                    ans = (ans + count)%mod;
                    count++;
                    j++;
                }
            }
            i = j;
        }
        return ans;
    }
}