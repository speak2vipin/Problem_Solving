class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int hold[] = new int[n];
        int free[] = new int[n];
        hold[0] = -prices[0];
        free[0] = 0;
        for(int i=1; i<n; i++) {
            if(i==1) {
                hold[i] = Math.max(hold[i-1], -prices[i]);
            } else {
                hold[i] = Math.max(hold[i-1], free[i-2] - prices[i]);
            }
            free[i] = Math.max(free[i-1], hold[i-1] + prices[i]);
        }
        return free[n-1]; 
    }
}