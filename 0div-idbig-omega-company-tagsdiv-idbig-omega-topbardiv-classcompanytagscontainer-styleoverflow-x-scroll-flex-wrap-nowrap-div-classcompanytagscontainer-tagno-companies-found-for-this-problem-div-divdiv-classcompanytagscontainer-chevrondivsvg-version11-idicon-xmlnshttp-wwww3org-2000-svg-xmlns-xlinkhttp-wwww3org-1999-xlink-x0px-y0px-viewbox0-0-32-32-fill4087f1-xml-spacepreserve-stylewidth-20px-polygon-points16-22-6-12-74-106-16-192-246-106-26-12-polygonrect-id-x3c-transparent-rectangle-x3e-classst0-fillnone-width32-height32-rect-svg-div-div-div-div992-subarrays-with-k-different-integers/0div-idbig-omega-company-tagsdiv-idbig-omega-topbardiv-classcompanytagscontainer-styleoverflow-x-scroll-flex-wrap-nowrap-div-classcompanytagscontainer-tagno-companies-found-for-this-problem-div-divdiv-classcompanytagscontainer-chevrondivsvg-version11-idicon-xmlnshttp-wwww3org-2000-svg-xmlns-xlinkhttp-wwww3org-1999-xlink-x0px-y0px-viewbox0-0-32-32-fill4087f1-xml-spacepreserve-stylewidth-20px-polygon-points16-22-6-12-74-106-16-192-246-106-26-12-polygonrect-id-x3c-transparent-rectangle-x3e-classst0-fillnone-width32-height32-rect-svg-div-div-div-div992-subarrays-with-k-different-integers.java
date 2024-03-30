class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return slidingWindowAtMostTarget(nums, k) - slidingWindowAtMostTarget(nums, k-1);
    }
    
    int slidingWindowAtMostTarget(int nums[], int target) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;
        int start = 0;
        int ans = 0;
        for(int end=0; end<n; end++) {
            freq.put(nums[end], freq.getOrDefault(nums[end], 0)+1);
            while(freq.size()>target) {
                freq.put(nums[start], freq.get(nums[start])-1);
                if(freq.get(nums[start])==0) {
                    freq.remove(nums[start]);
                }
                start++;
            }
            ans += end-start+1;
        }
        return ans;
    }
}