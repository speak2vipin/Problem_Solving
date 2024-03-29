class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int numsAndCost[][] = new int[n][2];
        for(int i=0; i<n; i++) {
            numsAndCost[i][0] = nums[i];
            numsAndCost[i][1] = cost[i];
        }
        Arrays.sort(numsAndCost, (a,b)->a[0] - b[0]);
      
        long total = 0;
        long prefixCost[] = new long[n];
        prefixCost[0] = numsAndCost[0][1];
        for(int i=1; i<n; i++) {
            total += 1l * numsAndCost[i][1]* (numsAndCost[i][0] - numsAndCost[0][0]);
            prefixCost[i] = numsAndCost[i][1] + prefixCost[i-1];
        }
        long answer = total;
        for(int i=1; i<n; i++) {
            int gap = numsAndCost[i][0] - numsAndCost[i-1][0];
            total = total + gap * prefixCost[i-1];
            total = total - gap * (prefixCost[n-1] - prefixCost[i-1]);
            answer = Math.min(answer, total);
        }
        return answer;
    }
}