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
        for(int i=0; i<n; i++) {
            if(i==0) {
                result[i] = prefix[n-1] - ((n-i)*nums[i]);
            } else if(i==n-1){
                result[i] = (n*nums[i])-prefix[n-1];
            } else {
                result[i] = ((i+1)*nums[i]) - prefix[i] 
                        + (prefix[n-1] - prefix[i] - (n-i-1)*nums[i]);
            }
        }
        return result;
    }
}