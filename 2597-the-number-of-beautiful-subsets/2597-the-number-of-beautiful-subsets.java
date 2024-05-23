class Solution {
    List<List<Integer>> subsets = null;
    
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        subsets = new ArrayList<>();
        
        findSubsets(nums, 0, new ArrayList<>(), k);
        int count = 0;
        for(List<Integer> subset : subsets) {
            //System.out.println(subset);
            if(isBeautiful(subset, k)) {
                count++;
            }
        }
        return count;
    }
    
    boolean isBeautiful(List<Integer> subset, int k) {
        for(int i=subset.size()-1; i>-1; i--) {
            //System.out.println(subset);
            if(subset.contains(subset.get(i)-k)){
                return false;
            }
        }
        return true;
    }
    
    void findSubsets(int nums[], int index, List<Integer> subset, int k) {
        if(index==nums.length) {
            if(!subset.isEmpty()) {
                //System.out.println(subset);
                subsets.add(new ArrayList<>(subset));
            }
            return;
        }
        subset.add(nums[index]);
        findSubsets(nums, index+1, subset, k);
        subset.remove(subset.size()-1);
        findSubsets(nums, index+1, subset, k);
    }
    
    
}