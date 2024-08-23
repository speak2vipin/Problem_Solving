class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer>first = new ArrayList<>();
        List<Integer>second = new ArrayList<>();
        first.add(nums[0]);
        second.add(nums[1]);
        int index1 = 0;
        int index2 = 1;
        for(int i=2; i<n; i++) {
            if(nums[index1]>nums[index2]) {
                first.add(nums[i]);
                index1 = i;
            } else {
                second.add(nums[i]);
                index2 = i;
            }
        }
        
        int res[] = new int[n];
        index1 = 0;
        for(Integer val : first) {
            res[index1++] = val;
        }
        for(Integer val : second) {
            res[index1++] = val;
        }
        return res;   
    }
}