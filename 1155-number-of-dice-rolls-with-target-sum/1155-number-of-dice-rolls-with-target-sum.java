class Solution {
    public int numRollsToTarget(int d, int f, int target) {
int[][] dp = new int[d+1][target+1];
dp[0][0] =1;
int mod = 1000000007;
for(int i=1;i<=d;i++){
for(int j=1;j<=f;j++){
for(int k= target;k>=j;k--){
if(dp[i-1][k-j]!=0){
dp[i][k]+=dp[i-1][k-j];
dp[i][k]%=mod;
}
}
}
}
return dp[d][target];
}
    }