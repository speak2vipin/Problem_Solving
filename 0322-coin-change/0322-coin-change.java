class Solution {
    public int coinChange(int[] coins, int amount) {
       int dp[] = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			int temp = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j]) {
					if(dp[Math.max(0, i - coins[j])] !=-1)
					      temp = Math.min(temp, dp[Math.max(0, i - coins[j])] + 1);
				}
			}
			dp[i] = (temp == Integer.MAX_VALUE) ? -1 : temp;
		}
		return dp[amount];
    }
}