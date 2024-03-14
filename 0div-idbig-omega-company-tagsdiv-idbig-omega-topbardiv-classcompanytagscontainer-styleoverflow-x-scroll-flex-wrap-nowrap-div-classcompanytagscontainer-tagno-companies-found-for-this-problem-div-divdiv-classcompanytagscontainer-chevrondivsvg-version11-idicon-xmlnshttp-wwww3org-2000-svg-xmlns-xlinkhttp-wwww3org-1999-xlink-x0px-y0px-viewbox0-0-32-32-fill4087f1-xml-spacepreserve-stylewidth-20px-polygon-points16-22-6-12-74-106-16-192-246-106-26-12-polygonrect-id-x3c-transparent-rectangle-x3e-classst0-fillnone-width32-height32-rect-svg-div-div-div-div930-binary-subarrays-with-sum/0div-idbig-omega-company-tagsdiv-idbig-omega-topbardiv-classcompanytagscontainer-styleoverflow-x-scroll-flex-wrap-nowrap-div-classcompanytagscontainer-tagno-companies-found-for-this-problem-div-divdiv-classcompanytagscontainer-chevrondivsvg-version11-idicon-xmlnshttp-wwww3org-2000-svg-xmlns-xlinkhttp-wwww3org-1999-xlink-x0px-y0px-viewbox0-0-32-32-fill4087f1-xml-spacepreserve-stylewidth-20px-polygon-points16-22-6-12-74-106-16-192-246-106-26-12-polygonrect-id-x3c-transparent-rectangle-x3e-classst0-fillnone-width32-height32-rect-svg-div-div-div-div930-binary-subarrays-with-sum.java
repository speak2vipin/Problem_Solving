class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        //int i = 0;
        //int j = 0;
        //int sum = 0;
        int count = 0;
       /* while(i<nums.length) {
            while(j<nums.length && sum<=goal) {
                if(nums[j]==goal){
                    count++;
                }
                sum += nums[j];
                j++;
                if(sum==goal){
                    count++;
                }
            }
            sum -= nums[i++];
            if(sum==goal){
                count++;
            }
        }*/
        for(int i=0; i<nums.length; i++) {
            int sum = 0;
            for(int j=i; j<nums.length; j++) {
                sum += nums[j];
                if(sum==goal){
                    count++;
                }
            }
        }
        return count;
    }
}