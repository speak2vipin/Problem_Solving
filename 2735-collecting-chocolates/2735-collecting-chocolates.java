class Solution {
    public long minCost(int[] nums, int x) {
        
        int N = nums.length;
        long res = Long.MAX_VALUE;
        int min[] = new int[N];
        Arrays.fill(min, Integer.MAX_VALUE);
        for(int k=0; k<N; k++) {
            long sum = (long) k * x;
            for(int i=0; i<N; i++) {
                min[i] = Math.min(min[i], nums[(i+k)%N]);
                sum += min[i];
            }
            res = Math.min(res, sum);
        }
        return res;
    }
}