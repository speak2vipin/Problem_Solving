class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        //int len = 0;
        int countNegative = 0;
        int lastZero = -1;
        int lastNegative = -1;
        int maxlen = 0;
        for(int i=0; i<n; i++) {
            if(nums[i]==0) {
                lastZero = i;
                lastNegative = -1;
                countNegative = 0;
            } else if(nums[i]<0) {
                countNegative++;
                if(lastNegative==-1) {
                    lastNegative = i;
                }
            }
            if(countNegative%2==0) {
                maxlen = Math.max(maxlen, i-lastZero);
            } else {
                maxlen = Math.max(maxlen, i-lastNegative);
            }
        }
        return maxlen;
    }
}