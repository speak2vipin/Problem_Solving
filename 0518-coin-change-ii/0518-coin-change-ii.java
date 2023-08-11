class Solution {
   
    int memo[][] = null;
    
    public int change(int amount, int[] coins) {
        int n = coins.length;
        memo = new int[n][amount+1];
        for(int row[] : memo){
            Arrays.fill(row, -1);
        }
        return noOfWays(0, amount, coins);
    }
    
    int noOfWays(int i, int amount, int[]coins) {
        if(amount==0) {
            return 1;
        }
        if(i==coins.length) {
            return 0;
        }
        if(memo[i][amount]!=-1) {
            return memo[i][amount];
        }
        if(coins[i]>amount) {
            return memo[i][amount] = noOfWays(i+1, amount, coins);
        }
        
        memo[i][amount] = noOfWays(i, amount-coins[i], coins)
                + noOfWays(i+1, amount, coins);
        return memo[i][amount];
    }
}