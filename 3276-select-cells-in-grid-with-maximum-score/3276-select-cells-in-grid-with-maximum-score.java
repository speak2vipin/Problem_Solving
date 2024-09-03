class Solution {
    int dp[][] = new int[101][1025];
    public int maxScore(List<List<Integer>> grid) {
        Map<Integer, ArrayList<Integer>> arr = new HashMap<>();
        for(int i=0; i<grid.size(); i++) {
            for(int j=0; j<grid.get(0).size(); j++) {
                arr.computeIfAbsent(grid.get(i).get(j), val->new ArrayList<>()).add(i);
            }
        }
        for(int d[] : dp) {
            Arrays.fill(d, -1);
        }
        return solve(arr, 100, 0);
        
        
    }
    
    int solve(Map<Integer, ArrayList<Integer>> arr, int idx, int mask) {
        if(idx==0) {
            return 0;
        }
        if(dp[idx][mask]!=-1) {
            return dp[idx][mask];
        }
        int res = solve(arr, idx-1, mask);
        for(int i : arr.getOrDefault(idx, new ArrayList<>())) {
            if((mask & (1<<i))==0) {
               res = Math.max(res, idx + solve(arr, idx-1, mask | (1<<i)));
            }
        }
        return dp[idx][mask] = res;
    }
}