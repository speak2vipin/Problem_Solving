class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer dp[][] = new Integer[n][3];
        return helper(dp, 0, 0, nums1, nums2);
    }
    
    int helper(Integer dp[][], int choice, int index, int nums1[], int nums2[]) {
        if(index==nums1.length) {
            return 0;
        }
        if(dp[index][choice]!=null) {
            return dp[index][choice];
        }
        
        int maxLen = 0;
        if(choice==0) {
            maxLen = Math.max(maxLen, helper(dp, 0, index+1, nums1, nums2));
        }
        int prev = ((choice==0) ? -1 :(choice==1 ? nums1[index-1] : nums2[index-1]));
        if(nums1[index]>=prev) {
            maxLen = Math.max(maxLen, 1 + helper(dp, 1, index+1, nums1, nums2));
        }
        if(nums2[index]>=prev) {
            maxLen = Math.max(maxLen, 1 + helper(dp, 2, index+1, nums1, nums2));
        }
        return dp[index][choice]=maxLen;
    }
}