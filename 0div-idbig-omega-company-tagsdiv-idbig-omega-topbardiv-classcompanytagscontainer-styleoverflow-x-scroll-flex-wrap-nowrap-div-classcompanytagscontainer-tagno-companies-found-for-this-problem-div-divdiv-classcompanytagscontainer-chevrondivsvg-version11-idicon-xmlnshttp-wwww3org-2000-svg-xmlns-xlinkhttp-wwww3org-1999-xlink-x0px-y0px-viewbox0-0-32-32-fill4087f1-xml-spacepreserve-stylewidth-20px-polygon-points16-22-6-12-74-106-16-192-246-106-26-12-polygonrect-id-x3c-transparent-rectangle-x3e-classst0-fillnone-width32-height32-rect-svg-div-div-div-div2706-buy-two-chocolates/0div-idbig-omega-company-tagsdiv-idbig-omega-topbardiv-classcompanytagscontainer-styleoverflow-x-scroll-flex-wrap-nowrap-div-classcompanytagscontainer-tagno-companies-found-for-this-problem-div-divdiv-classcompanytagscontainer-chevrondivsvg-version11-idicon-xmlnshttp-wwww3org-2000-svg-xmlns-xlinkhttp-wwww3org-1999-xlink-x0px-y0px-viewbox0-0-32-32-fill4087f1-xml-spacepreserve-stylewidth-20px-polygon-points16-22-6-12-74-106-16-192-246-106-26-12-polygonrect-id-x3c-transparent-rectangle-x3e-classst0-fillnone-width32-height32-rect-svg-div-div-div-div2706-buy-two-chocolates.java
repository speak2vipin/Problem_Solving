class Solution {
    public int buyChoco(int[] prices, int money) {
        int first = prices[0] > prices[1] ? prices[1] : prices[0];
        int second = prices[1] > prices[0] ? prices[1] : prices[0];
        int n = prices.length;
        for(int i=2; i<n; i++) {
            if(first>prices[i]) {
                second = first;
                first = prices[i];
            } else if(second>prices[i]) {
                second = prices[i];
            }
        }
        return money-first-second<0?money:money-first-second;
    }
}