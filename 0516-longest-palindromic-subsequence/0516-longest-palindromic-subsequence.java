class Solution {
    int n = 0;
    public int longestPalindromeSubseq(String s) {
		n = s.length();
		int dp[][] = new int[n][n];
		
		return evaluate(dp, 0, n - 1, s);
	}

	int evaluate(int dp[][], int i, int j, String s) {
		//System.out.println(i + " " + j + " " + dp[i][j] +" " + s.substring(i,j+1));
		if (dp[i][j] != 0) {
			return dp[i][j];
		}
		if (i > j) {
			return 0;
		}
		if (i == j) {
			return 1;
		}
		if (s.charAt(i) == s.charAt(j)) {
			dp[i][j] = 2 + evaluate(dp, i + 1, j - 1, s);
		} else {
			dp[i][j] = Math.max(evaluate(dp, i + 1, j, s), evaluate(dp, i, j - 1, s));
		}
		
		return dp[i][j];
	}
}