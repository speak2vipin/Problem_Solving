class Solution {
    
    int groupNew[] = null;
    int profitNew[] = null;
    int minProfitNew = 0;
    int maxPeople = 0;
    int len = 0;
    int mod = 1000_000_007;
    int dp[][][] = null;
    
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        groupNew = group;
        profitNew = profit;
        minProfitNew = minProfit;
        maxPeople = n;
        len = group.length;
        dp = new int[101][101][101];
        for(int i=0; i<101; i++) {
            for(int j=0; j<101; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return noOfWays(0, 0, 0);
    }
    
    int noOfWays(int pos, int peopleCount, int currProfit) {
        if(pos >= len) {
            return currProfit >= minProfitNew ? 1 : 0;
        }
        if(dp[pos][peopleCount][currProfit] != -1) {
            return dp[pos][peopleCount][currProfit];
        }
        int totalWays = noOfWays(pos+1, peopleCount, currProfit);
        if((peopleCount + groupNew[pos]) <= maxPeople) {
            totalWays += noOfWays(pos+1, Math.min(100, (peopleCount + groupNew[pos])), Math.min(100, (currProfit + profitNew[pos])));
        }
        
        dp[pos][peopleCount][currProfit] = totalWays%mod;
       
        return dp[pos][peopleCount][currProfit];
    }
}