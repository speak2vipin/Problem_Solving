class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int dp[] = new int[26];
        int res = 1;
        for(int i=0; i<n; i++) {
            int curr = s.charAt(i)-'a';
            int best = 0;
            for(int prev = Math.max(0, curr-k); prev<Math.min(26, curr+k+1); prev++) {
                best = Math.max(best, dp[prev]);
            }
            dp[curr] = best+1; // As that character will contribute 1 by itself
            res = Math.max(res, dp[curr]);
        }
        return res;
    }
}