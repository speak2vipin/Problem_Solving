class Solution {
    public int maximumJumps(int[] nums, int target) {
        /*int jumps = 0;
        int st = 0;
        int en = nums.length;
        int tempSt = st;
        while(tempSt<en) {
            int temp = tempSt+1;
            while(temp<en && (Math.abs(nums[tempSt]-nums[temp]))<=target) {
                st = temp;
                jumps++;
                tempSt = temp;
                temp++;
            }
            tempSt = temp;
        }
        return (st==en-1) ? jumps : -1;
        */
        
        int n = nums.length;
        int dp[]= new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        return helper(nums, dp, 0, target, nums[0]); 
    }
    
    int helper(int nums[], int dp[], int index, int target, int last) {
        if(index==dp.length-1) {
            return 0;
        }
        if(dp[index]!=Integer.MIN_VALUE) {
            return dp[index];
        }
        int res=-1;
        for(int i=index+1; i<dp.length; i++) {
            if(Math.abs(nums[i]-last)<=target) {
                int t = helper(nums, dp, i, target, nums[i]);
                if(t!=-1) {
                    res = Math.max(t+1, res);
                }
            }
        }
        return dp[index] = res;
    }
}