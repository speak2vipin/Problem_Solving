class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        Map<Long, Integer>[] dp = new Map[n];
        int res = 0;
        for(int i=0; i<n; i++) {
            dp[i] = new HashMap<>();
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                long diff = (long)nums[i]-nums[j];
            
                int c1 = dp[i].getOrDefault(diff, 0);
                int c2 = dp[j].getOrDefault(diff, 0);
                res += c2;
                dp[i].put(diff, c1+c2+1);
            }
        }
        return res;
         
        
    }
}