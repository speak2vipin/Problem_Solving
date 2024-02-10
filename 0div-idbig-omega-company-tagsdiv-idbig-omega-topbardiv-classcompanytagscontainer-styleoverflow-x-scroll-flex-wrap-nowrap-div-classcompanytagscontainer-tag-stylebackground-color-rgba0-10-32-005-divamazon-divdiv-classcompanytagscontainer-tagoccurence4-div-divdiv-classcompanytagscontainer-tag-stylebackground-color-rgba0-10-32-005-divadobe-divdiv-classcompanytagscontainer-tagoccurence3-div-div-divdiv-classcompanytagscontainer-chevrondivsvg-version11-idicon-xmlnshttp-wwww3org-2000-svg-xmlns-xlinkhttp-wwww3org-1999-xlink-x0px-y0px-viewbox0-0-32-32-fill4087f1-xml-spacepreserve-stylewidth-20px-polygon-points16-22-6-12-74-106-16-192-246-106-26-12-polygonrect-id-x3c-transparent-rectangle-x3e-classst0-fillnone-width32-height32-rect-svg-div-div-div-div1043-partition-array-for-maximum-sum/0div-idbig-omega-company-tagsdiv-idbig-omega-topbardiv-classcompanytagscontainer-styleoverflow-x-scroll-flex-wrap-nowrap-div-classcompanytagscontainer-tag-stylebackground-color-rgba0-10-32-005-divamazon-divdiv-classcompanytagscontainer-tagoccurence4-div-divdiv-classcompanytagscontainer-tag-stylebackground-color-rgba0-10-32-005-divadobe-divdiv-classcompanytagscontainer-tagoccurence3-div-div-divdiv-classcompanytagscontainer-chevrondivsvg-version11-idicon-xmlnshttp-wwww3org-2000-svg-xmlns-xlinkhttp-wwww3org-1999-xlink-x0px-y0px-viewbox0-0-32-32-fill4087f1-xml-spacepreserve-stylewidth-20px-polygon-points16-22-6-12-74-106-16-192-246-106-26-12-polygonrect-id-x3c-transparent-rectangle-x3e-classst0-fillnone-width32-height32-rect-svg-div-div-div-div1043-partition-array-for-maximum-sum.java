class Solution {
    int dp[] = null;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return helper(0, arr, k);
    }
    
    int helper(int i, int arr[], int k) {
        if(i>=arr.length) {
            return 0;
        }
        if(dp[i]!=-1) {
            return dp[i];
        }
        int sum = 0;
        int max = arr[i];
        for(int j=i; j<Math.min(i+k, arr.length); j++) {
            max = Math.max(max, arr[j]);
            sum = Math.max(sum, (max*(j-i+1) + helper(j+1, arr, k)));
        }
        return dp[i] = sum;
    }
}