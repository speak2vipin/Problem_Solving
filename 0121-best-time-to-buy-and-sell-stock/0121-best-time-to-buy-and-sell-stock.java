class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int min = prices[0];
        int ans = 0;
        for(int i=1; i<N; i++) {
            if(min<prices[i]) {
                ans=Math.max(ans, prices[i]-min);
            } else {
                min=prices[i];
            }
        }
        return ans;
    }
}