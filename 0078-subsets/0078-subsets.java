class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        
        helper(nums, 0, subsets, new ArrayList<>());
   
        return subsets;
        
    }
    
    void helper(int nums[], int index, List<List<Integer>> subsets, List<Integer> subset) {
        if(index==nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        helper(nums, index+1, subsets, subset);
        subset.remove(subset.size()-1);
        helper(nums, index+1, subsets, subset);
    }
}