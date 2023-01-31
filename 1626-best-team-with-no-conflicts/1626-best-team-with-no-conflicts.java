class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int N = scores.length;
        int input[][] = new int[N][N];
        for(int i=0; i<N; i++) {
            input[i]=new int[]{ages[i], scores[i]};
        }
        Arrays.sort(input, (a,b)->a[0]==b[0] ? a[1]-b[1] :a[0]-b[0]);
        int dp[] = new int[N];
        int ans = 0;
        for(int i=0; i<N; i++) {
            dp[i] = input[i][1];
            ans = Math.max(ans, dp[i]);
        }
        for(int i=0; i<N; i++) {
            for(int j=i-1; j>-1; j--) {
                if(input[i][1]>=input[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j]+input[i][1]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }    
}