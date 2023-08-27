class Solution {
    // Logic:
        // TRy to find a block with minimum second value so that second block can be considered as soon as possible
        // Sort Array by second value
        // find pairs count which are increasing
    
    public int findLongestChain(int[][] pairs) {        
	       /* Arrays.sort(pairs, (x,y) -> (x[1] - y[1]));
	        int n = pairs.length;
	        int j = 1;
	        int prev = pairs[0][1];
	        int count = 1;
	        while(j<n) {
	            if(pairs[j][0]>prev) {
	                count++;
	                prev = pairs[j][1];
	            }
	            j++;
	        }
	        return count;  
            */
        Arrays.sort(pairs, (x,y)->(x[0]-y[0]));
        int n = pairs.length;
        int dp[][] = new int[n][n+1];
        for(int []row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, -1, pairs, dp);
    }
    
    int helper(int i, int prev, int pairs[][], int dp[][]) {
		if (i >= pairs.length) {
			return 0;
		}
		if (dp[i][prev+1] != -1) {
			return dp[i][prev+1];
		}
		
		int pick = 0;
		if (prev==-1 || pairs[prev][1] < pairs[i][0]) {
			pick = 1 + helper(i + 1, i, pairs, dp);
		}
		int no_Pick = helper(i+1, prev, pairs, dp);
		return dp[i][prev+1] = Math.max(pick, no_Pick);
	}
}