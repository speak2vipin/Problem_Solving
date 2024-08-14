class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        
        int max = Integer.MIN_VALUE;
        
        for(int num : nums) {
            max = Math.max(max, num);
        }
        
        int bucket[] = new int[max+1];
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                ++bucket[Math.abs(nums[j]-nums[i])];
            }
        }
        for(int dist = 0; dist<=max; dist++) {
            k -= bucket[dist];
            if(k<=0) {
                return dist;
            }
        }
        return -1;
        
    }
}