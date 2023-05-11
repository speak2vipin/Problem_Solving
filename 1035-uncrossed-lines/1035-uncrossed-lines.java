class Solution {
    int dp[][] = null;
    
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        dp = new int[len1][len2];
        for(int tempdp[] : dp) {
            Arrays.fill(tempdp, -1);
        }
        
        helper(nums1, nums2, 0, 0);
        
        return dp[0][0];
        
    }
    
    int helper(int nums1[], int nums2[], int i, int j) {
        if(i==nums1.length || j==nums2.length) {
            return 0;
        }
        if(dp[i][j]!=-1) {
            return dp[i][j];
        }
        int val = 0;
        if(nums1[i]==nums2[j]) {
            val = 1 + helper(nums1, nums2, i+1, j+1);
        } else {
            val = Math.max(helper(nums1, nums2, i+1, j),  helper(nums1, nums2, i, j+1));
        }
        return dp[i][j] = val;
    }
}