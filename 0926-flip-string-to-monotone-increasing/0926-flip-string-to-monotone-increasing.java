class Solution {
    public int minFlipsMonoIncr(String s) {
        int L = s.length();
        int count=0;
        int dp[] = new int[L];  
        if(s.charAt(0)=='1') {
            count++;
        }
        for(int i=1; i<L; i++) {
            if(s.charAt(i)=='1') {
                count++;
                dp[i] = dp[i-1];
            } else {
                dp[i] = Math.min(count, dp[i-1]+1);
            }
        }
        return dp[L-1];
    }
}