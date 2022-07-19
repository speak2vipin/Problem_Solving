class Solution {
   
    public static boolean containsNearbyDuplicate(int[] nums, int k)  {
        Set<Integer> numSet = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++) {
            if(i>k) {
                numSet.remove(nums[i-k-1]);
            }
            if(!numSet.add(nums[i])) {
                return true;
            }
        }
        return false;
    
    }
}