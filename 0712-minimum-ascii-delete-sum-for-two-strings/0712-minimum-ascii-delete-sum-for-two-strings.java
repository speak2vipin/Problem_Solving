class Solution {
    // Logic is similar to longest common subsequence question
    // create a 2-d array
        // for all i's & j=0 -> sum of deleting all the character of s1
        // for all j's & i=0 -> sum of deleting all the character of s2
    // Simple iteration
        // if(s1.charAt(i-1)==s2.charAt(j-1)) => dp[i][j] = dp[i-1][j-1];
        // else dp[i][j] = Math.min(s1.charAt(i-1) + dp[i-1][j], s2.charAt(j-1) + dp[i][j-1])
    
    public int minimumDeleteSum(String s1, String s2) {
    
        int l1 = s1.length();
        int l2 = s2.length();
        
        int dp[][] = new int[l1+1][l2+1];
        
        for(int i=1; i<l1+1; i++) {
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }
        for(int j=1; j<l2+1; j++) {
            dp[0][j] = dp[0][j-1] + s2.charAt(j-1);
        }
        
        for(int i=1; i<l1+1; i++) {
            for(int j=1; j<l2+1; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(s1.charAt(i-1) + dp[i-1][j], s2.charAt(j-1) + dp[i][j-1]);
                }
            }
        }
        return dp[l1][l2];
         
    }
}