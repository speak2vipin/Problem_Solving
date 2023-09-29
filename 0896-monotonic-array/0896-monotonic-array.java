class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        
        int isNegative = -1;
        int i = 1;
        while(i<n) {
            int diff = nums[i]-nums[i-1];
            if(diff == 0) {
                
            } else if(isNegative==-1) {
                isNegative = diff > 0 ? 1 : 0;
            } else if(diff > 0 && isNegative==0) {
                return false;
            } else if(diff < 0 && isNegative==1) {
                return false;
            }
            i++;
        }
        return true;
    }
}