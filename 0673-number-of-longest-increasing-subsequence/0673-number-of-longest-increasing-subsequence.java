class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        
        int count[] = new int[n];
        int length[] = new int[n];
        Arrays.fill(count, 1);
        Arrays.fill(length, 1);
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[j]<nums[i]) {
                    if(length[j]+1>length[i]) {
                        length[i] = length[j]+1;
                        count[i] = 0;
                    }
                    if(length[j]+1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }
        int maxLength = 0;
        for(int i=0; i<n; i++) {
            maxLength = Math.max(maxLength, length[i]);
        }
        int res = 0;
        for(int i=0; i<n; i++) {
            if(maxLength==length[i]) {
                res += count[i];
            }
        }
        return res;
        
    }
}