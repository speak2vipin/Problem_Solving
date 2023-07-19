class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> index = new HashMap<>();
        int res[] = new int[2];
        for(int i=0; i<nums.length; i++) {
            if(index.get(target-nums[i])!=null) {
                res[0] = index.get(target-nums[i]);
                res[1] = i;
                break;
            } 
            if(index.get(nums[i])==null)
                index.put(nums[i], i);
        }
        return res;
    }
}