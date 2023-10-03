class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        int count[] = new int[101];
        int res = 0;
        for(int num : nums) {
            count[num]++;
        }
        for(int i=1; i<101; i++) {
            res += (count[i] * (count[i]-1))/2; 
        }
        return res;
    }
}