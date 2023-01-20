class Solution {
    int N = 0;
    Set<List<Integer>> subsets = new HashSet<List<Integer>>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        N = nums.length;
        helper(nums, 0, new ArrayList<Integer>());
        return new ArrayList(subsets);   
    }
    
    void helper(int[]nums, int index, List<Integer> subset) {
        if(N==index) {
            // At least two elements given in question
            if(subset.size()>=2) {
                List<Integer> l = new ArrayList<Integer>();
                l.addAll(subset);
                subsets.add(l);
            }
            return;
        }
        int size = subset.size();
        // If increasing then only proceed
        if(size==0 || nums[index]>=subset.get(size-1)) {
             subset.add(nums[index]);
             helper(nums, index+1, subset);
             size = subset.size(); 
            // Once done with that indexed element then take next
             subset.remove(size-1);
        } 
        // Process next index element
        helper(nums, index+1, subset);
    }
}