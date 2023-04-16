class Solution {
    int mod = 1000000007;
	Integer dp[][] = null;
	long count[][];
	int maxLength = 0;

	public int numWays(String[] words, String target) {
		//int mod = 1000000007;
		maxLength = words[0].length();
		count = new long[1000][26];
		for(String word : words) {
			maxLength = Math.max(maxLength, word.length());
			for(int i=0; i<word.length(); i++) {
				count[i][word.charAt(i)-'a']++;
			}
		}
		dp = new Integer[maxLength][target.length()];
		return calculate(target, 0, 0);

	}

	int calculate(String target, int j, int i) {
		if (i == target.length()) {
			return 1;
		}
		if (j == maxLength) {
			return 0;
		}
		if (dp[j][i] != null) {
			return dp[j][i];
		}
		int res = 0;
		int index = target.charAt(i)-'a';
		if (count[j][index] > 0) {
			res = (int) ((count[j][index] * calculate(target, j + 1, i + 1 )) % mod);
		}
		res = (res + calculate(target, j+1, i)) % mod;
		dp[j][i] = res;
		return dp[j][i];
	}
}