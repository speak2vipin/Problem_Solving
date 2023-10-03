class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        int i=0;
        while(i<n) {
            int j=i+1;
            while(j<n && nums[j]==nums[i]) {
                j++;
            }
            int number = j-i-1;
            count += (number * (number+1))/2;
            i=j;
        }
        return count;
    }
}