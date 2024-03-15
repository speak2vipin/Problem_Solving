class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if(n==1) {
            return nums;
        }
        int prefix[] = new int[n];
        int postfix[] = new int[n];
        int result[] = new int[n];
        prefix[0] = nums[0];
        postfix[n-1] = nums[n-1];
        for(int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] * nums[i];
            postfix[n-1-i] = postfix[n-1-i+1] * nums[n-1-i];
        }
        
        for(int i=0; i<n; i++) {
            if(i==0) {
                result[i] = postfix[i+1];
            } else if(i==n-1) {
                result[i] = prefix[i-1];
            } else {
                result[i] = prefix[i-1] * postfix[i+1];
            }
        }
        return result;
        
    }
}