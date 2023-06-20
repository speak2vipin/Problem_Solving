class Solution {
    public int[] getAverages(int[] nums, int k) {
        int N = nums.length;
        int res[] = new int[N];
        long prefix[] = new long[N];
        for(int i=0; i<N; i++) {
            if(i==0) {
                prefix[0] = nums[0];
            } else {
                prefix[i] = nums[i] + prefix[i-1];
            }
        }
        Arrays.fill(res, -1);
        long total = 0;
        for(int i=k; i<N; i++) {
            if((i+k)<N) {
                if(i-k-1<0) {
                    total = prefix[i+k];
                } else {
                    total = prefix[i+k] - prefix[i-k-1];
                }
                res[i] = (int)(total/(2*k + 1));
            }
        }
        return res;
    }
}