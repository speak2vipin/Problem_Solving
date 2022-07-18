class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet =  new HashSet<Integer>();
        for(Integer integer : nums) {
            if(!numSet.add(integer)) {
                return true;
            }
        }
        return false;
    }
}