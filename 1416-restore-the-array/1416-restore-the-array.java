class Solution {
    int dp[] = null;
    int mod = 1000_000_007;
    
    public int numberOfArrays(String s, int k) {
        int m = s.length();
        dp = new int[m+1];
        return process(s, 0, k);
    }
    
    int process(String s, int st, int k) {
        if(dp[st] != 0) {
            return dp[st];
        }    
        if(st == s.length()) {
            return 1;
        }
        if(s.charAt(st)=='0') {
            return 0;
        }
        int count = 0;
        for(int end = st; end<s.length(); end++) {
            String number = s.substring(st, end+1);
            if(Long.parseLong(number)>k) {
                break;
            }
            count = (count + process(s, end+1, k))%mod;
        }
        dp[st] = count;
        return dp[st];
    }
    
}