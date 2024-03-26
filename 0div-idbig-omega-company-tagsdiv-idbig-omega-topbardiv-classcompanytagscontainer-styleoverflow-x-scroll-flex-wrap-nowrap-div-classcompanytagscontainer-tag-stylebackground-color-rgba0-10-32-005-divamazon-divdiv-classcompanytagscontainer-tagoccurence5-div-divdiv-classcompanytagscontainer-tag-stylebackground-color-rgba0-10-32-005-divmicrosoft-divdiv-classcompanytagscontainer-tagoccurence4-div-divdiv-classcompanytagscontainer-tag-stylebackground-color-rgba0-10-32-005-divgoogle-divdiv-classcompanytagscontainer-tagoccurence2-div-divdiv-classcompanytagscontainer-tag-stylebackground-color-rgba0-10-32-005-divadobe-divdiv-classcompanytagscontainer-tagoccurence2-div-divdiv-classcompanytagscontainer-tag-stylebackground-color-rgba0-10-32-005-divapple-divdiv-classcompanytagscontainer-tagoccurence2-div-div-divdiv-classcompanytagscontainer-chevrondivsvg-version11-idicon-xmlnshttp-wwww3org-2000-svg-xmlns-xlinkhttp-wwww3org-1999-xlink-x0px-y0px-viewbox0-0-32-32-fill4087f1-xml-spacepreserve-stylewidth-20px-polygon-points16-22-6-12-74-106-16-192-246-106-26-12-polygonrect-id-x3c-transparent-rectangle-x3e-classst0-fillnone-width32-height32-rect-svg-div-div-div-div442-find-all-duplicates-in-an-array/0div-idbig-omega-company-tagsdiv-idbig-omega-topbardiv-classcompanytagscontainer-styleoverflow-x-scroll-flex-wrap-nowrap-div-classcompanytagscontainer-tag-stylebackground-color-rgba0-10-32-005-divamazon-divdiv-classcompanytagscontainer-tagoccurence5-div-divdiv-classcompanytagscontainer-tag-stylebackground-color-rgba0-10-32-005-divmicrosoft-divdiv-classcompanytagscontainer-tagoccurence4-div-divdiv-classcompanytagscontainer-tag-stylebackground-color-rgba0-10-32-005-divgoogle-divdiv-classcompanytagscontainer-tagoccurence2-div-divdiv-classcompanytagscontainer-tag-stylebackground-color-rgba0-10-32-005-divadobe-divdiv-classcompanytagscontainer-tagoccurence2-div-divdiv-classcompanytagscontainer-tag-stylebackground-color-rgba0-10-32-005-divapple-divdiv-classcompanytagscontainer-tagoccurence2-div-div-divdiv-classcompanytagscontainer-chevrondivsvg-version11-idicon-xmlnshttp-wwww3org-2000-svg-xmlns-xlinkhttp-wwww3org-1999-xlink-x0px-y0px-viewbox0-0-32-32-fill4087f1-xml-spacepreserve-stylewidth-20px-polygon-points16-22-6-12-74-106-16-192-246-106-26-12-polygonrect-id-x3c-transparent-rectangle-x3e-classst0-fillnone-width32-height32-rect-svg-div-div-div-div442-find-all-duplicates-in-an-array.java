class Solution {
    // https://youtu.be/lFhiz9ntwqk
    // Here the crux lies in the range of values exist in nums i.e. 1 - N
    // So we can track array index by Array elements
    // find the abs value and mark that element visited by making it -ve
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n ; i++) {
            int index = Math.abs(nums[i])-1;
            if(nums[index]<0) {
                duplicates.add(index+1);
            }
            nums[index] = nums[index]*-1;
        }
        return duplicates;
    }
}