class Solution {
    // Logic:
    // Consider every stone as the first stone or step
    // So ideally it will be of Alice & i+1 will be of Bob
    // So stoneValue[i] - dp[i+1] will be tje difference between Alice's and Bob
    // If dp[0] > 0 i.e. Alice has won or Bob will won.
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int dp[] = new int[n+1];
        for(int i=n-1; i>-1; i--) {
            dp[i] = stoneValue[i]-dp[i+1];
            if(i+2<=n) {
                dp[i] = Math.max(dp[i], stoneValue[i]+ stoneValue[i+1] - dp[i+2]);
            }
            if(i+3<=n) {
                dp[i] = Math.max(dp[i], stoneValue[i]+ stoneValue[i+1] + stoneValue[i+2]  - dp[i+3]);
            }
        }
        if(dp[0]>0) {
            return "Alice";
        }
        if(dp[0]<0) {
            return "Bob";
        }
        return "Tie";
    }
}