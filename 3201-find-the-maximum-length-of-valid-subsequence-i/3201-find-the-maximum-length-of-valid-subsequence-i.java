class Solution {
    public int maximumLength(int[] nums) {
        boolean evenFlag = nums[0]%2==0;
        int i = 1;
        int count = 1;
        int even = evenFlag?1:0;
        int odd = evenFlag?0:1;
        while(i<nums.length) {
            if(evenFlag && nums[i]%2!=0) {
                count++;
                evenFlag = !evenFlag;
            } else if(!evenFlag && nums[i]%2==0) {
                count++;
                evenFlag = !evenFlag;
            }
            if(nums[i]%2==0) {
                even++;
            } else {
                odd++;
            }
            i++;
        }
        
        return Math.max(count, Math.max(even, odd));
    }
    
    //int longestSubSequnce
}