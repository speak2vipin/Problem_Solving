class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        
        int direction = 0;
        int i = 1;
        while(i<n) {
            int diff = nums[i]-nums[i-1];
            if(diff == 0) {
                
            } else if(direction==0) {
                direction = diff > 0 ? 1 : -1;
            } else if(diff > 0 && direction==-1) {
                return false;
            } else if(diff < 0 && direction==1) {
                return false;
            }
            i++;
        }
        return true;
    }
}