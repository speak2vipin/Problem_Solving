class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int M = nums.length;
        for(int i=1; i<M; i++) {
            nums[i] += nums[i-1];
        }
        int N = queries.length;
        int ans[] = new int[N];
        for(int j=0; j<N; j++) {
            ans[j] = binarySearch(nums, queries[j]);
        }
        return ans;   
    }
    
    int binarySearch(int prefixSum[], int target) {
        int left = 0;
        int right = prefixSum.length-1;
        while(left<right) {
            int mid = (left + right)/2;
            if(prefixSum[mid] > target) {
                right = mid-1;
            } else if(prefixSum[mid] < target) {
                left = mid+1;
            } else {
                return mid+1;
            }
        }
        return prefixSum[left]>target ? left : left+1;
        
    }
}