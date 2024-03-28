class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int start = 0;
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int ans = Integer.MIN_VALUE;
        for(int end = 0; end<n; end++) {
            freq.put(nums[end], freq.getOrDefault(nums[end], 0)+1);
            while(freq.get(nums[end])>k) {
                freq.put(nums[start], freq.get(nums[start])-1);
                start++;
            }
            ans = Math.max(ans, end-start+1);
        }
        return ans;
    }
}