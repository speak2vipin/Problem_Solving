class Solution {
    List<List<Integer>> ans = null;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), candidates, target, 0);
        return ans;
    }
    
    private void backtrack(List<Integer>curr, int[]candidates, int target, int index) {
        if(target<0) {
            return;
        } else if(target==0) {
            ans.add(new ArrayList<>(curr));
        } else {
            for(int i=index; i<candidates.length && target>=candidates[i]; i++) {
                if(i>index && candidates[i]==candidates[i-1]) {
                    continue;
                }
                curr.add(candidates[i]);
                backtrack(curr, candidates, target-candidates[i], i+1);
                curr.remove(curr.size()-1);                
            }
        }
        // 10,1,2,7,6,1,5], target = 8
        // 1 1 2 5 6 7 10
    }
}