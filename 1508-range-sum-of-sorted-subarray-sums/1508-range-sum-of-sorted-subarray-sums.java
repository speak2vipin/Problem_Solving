class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = 1000_000_007;
        List<Long> sumList = new ArrayList<>();
        for(int i=1; i<n+1; i++) {
            for(int j=i; j<n+1; j++) {
                long sum = 0l;
                for(int k=i; k<=j; k++) {
                    sum = (sum + nums[k-1])%mod;
                }
                sumList.add(sum);
            }
        }
        Collections.sort(sumList, (x,y)->Long.compare(x, y));
        long res = 0;
        for(int i=left-1; i<right; i++) {
            res = (res + sumList.get(i))%mod;
        }
        return (int)res;
    }
}