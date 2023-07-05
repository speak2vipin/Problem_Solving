class Solution {
    public int longestSubarray(int[] nums) {
       /* int i=0; 
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
        */
        int start = 0;
        int n = nums.length;
        int zeroCount = 0;
        int res = 0;
        for(int i=0; i<n; i++) {
            zeroCount += (nums[i]==0) ? 1 : 0;
            while(zeroCount>1) {
                zeroCount -= (nums[start]==0) ? 1 : 0;
                start++;  
            }
            res = Math.max(res, i-start);
        }
        return res;
    }
}