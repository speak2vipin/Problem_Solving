class Solution {
    public static boolean containsNearbyDuplicate(int[] nums, int k)  {
        Map<Integer, Integer> numIndexMap = new HashMap<Integer, Integer>();
        for(int i = 0 ; i<nums.length; i++) {
            Integer numIndex = (Integer)numIndexMap.put(nums[i], i);
            if(numIndex!=null && Math.abs(numIndex-i)<=k) {
                return true;
            }
        }
        return false;
    
    }
}