class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<Long>();
        treeSet.add((long)nums[0]);
        for(int i=1; i<nums.length;i++) {
            if(i>k) {
                treeSet.remove((long)nums[i-k-1]);
            }
            long left = (long)nums[i]-t;
            long right = (long)nums[i]+t;
            if(!treeSet.subSet(left, right+1).isEmpty()) {
                return true;
            }
            treeSet.add((long)nums[i]);
        }
        return false;
        }
}