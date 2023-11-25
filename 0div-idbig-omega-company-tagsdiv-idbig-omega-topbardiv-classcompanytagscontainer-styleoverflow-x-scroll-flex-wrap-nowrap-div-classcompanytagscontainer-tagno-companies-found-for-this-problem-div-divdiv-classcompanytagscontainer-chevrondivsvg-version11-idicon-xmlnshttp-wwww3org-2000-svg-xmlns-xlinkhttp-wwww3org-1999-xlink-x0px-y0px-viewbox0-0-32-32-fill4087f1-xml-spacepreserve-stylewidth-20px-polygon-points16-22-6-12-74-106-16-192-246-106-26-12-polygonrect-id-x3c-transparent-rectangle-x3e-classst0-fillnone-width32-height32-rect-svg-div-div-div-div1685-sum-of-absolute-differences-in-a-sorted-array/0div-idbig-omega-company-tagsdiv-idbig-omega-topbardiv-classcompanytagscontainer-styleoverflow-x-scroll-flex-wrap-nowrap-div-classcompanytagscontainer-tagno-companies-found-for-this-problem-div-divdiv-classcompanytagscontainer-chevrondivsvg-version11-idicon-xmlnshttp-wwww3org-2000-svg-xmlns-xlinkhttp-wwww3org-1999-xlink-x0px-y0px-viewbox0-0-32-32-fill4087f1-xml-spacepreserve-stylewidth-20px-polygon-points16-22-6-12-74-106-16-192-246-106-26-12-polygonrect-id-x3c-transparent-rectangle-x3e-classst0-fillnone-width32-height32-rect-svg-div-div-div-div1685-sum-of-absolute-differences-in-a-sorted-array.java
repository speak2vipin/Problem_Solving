class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n];

        for(int i=0; i<n; i++) {
            if(i==0) {
                prefix[i] = nums[0];
            } else {
                prefix[i] = prefix[i-1] + nums[i];
            }
        }
        
        int result[] = new int[n];
        int val = 0;
        for(int i=0; i<n; i++) {
            if(i==0) {
                val = prefix[n-1] - ((n-i)*nums[i]);
            } else if(i==n-1){
                val = (n*nums[i])-prefix[n-1];
            } else {
                val = ((i+1)*nums[i]) - prefix[i] 
                        + (prefix[n-1] - prefix[i] - (n-i-1)*nums[i]);
            }
            result[i] = val;
        }
        return result;
    }
}