class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        while(j<n && i<n) {
            if((nums[j]%2)!=0) {
                i = Math.max(i, j);
                while(i<n && (nums[i]%2)!=0) {
                    i++;
                }
                if(i<n) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            } 
            j++;
        }
        return nums;
    }
}