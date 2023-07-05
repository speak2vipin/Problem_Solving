class Solution {
    public int longestSubarray(int[] nums) {
        int i=0; 
        int j=0;
        int n = nums.length;
        int res = 0;
        while(i<n) {
            if(nums[i]==1) {
                int count = 1;    
                boolean isZero = false;
                j = i+1;
                while(j<n) {
                    if(nums[j]==0) {
                        if(isZero) {
                            break;
                        } 
                        isZero = true;
                    } else {
                        count++;
                    }
                    j++;
                }
                res = Math.max(res, count);
                while(i<n && nums[i]!=0) {
                    i++;
                }
            } else {
                i++;
            }
        }
        return res==n?res-1:res;
    }
}