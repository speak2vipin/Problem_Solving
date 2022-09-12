class Solution {
    public int majorityElement(int[] nums) {
        // More algorithms
        int N = nums.length;
        int ans = nums[0];
        int count = 1;
        for(int i=1;i<N;i++) {
            if(nums[i]==ans) {
                count++;
            } else if(count==0) {
                ans = nums[i];
                count++;  
            } else {
                count--;
            }
        }
        return ans;  
    }
}