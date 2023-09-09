class Solution {
    List<List<Integer>> response = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer>subset = new ArrayList<>();
        backtrack(0, candidates, target, subset);
        return response;
    }
    
    void backtrack(int index, int[] candidates, int target, List<Integer>subset)     {
        if(index==candidates.length) {
            return;
        }
        if(target==0) {
            response.add(new ArrayList<>(subset));
            return;
        }
        if(target<0) {
            return;
        }
        if(target-candidates[index]>=0) {
            subset.add(candidates[index]);
            backtrack(index, candidates, target-candidates[index], subset);
            subset.remove(subset.size()-1);
        }
        backtrack(index+1, candidates, target, subset);
    }
    
}