class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int N = nums.length;
        int Q = queries.length;
        int temp[] = new int[2];
        int ans = 0;
        int response[] = new int[N];
        int prevValue = 0;
        for(int i=0; i<N; i++) {
            if(nums[i]%2==0) {
                ans+=nums[i];
            }
        }
        for(int i=0; i<Q; i++) {
            temp = queries[i];
            prevValue = nums[temp[1]];
            nums[temp[1]] = nums[temp[1]] + temp[0];
            if(prevValue%2==0) {
                ans -= prevValue;
            }
            if(nums[temp[1]]%2==0) {
                ans += nums[temp[1]];
            }
            response[i] = ans;
        }
        return response;
    }
}