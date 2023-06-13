class Solution {
    // Logic:
        // Based on 2-pointer approach
        // Simpley Sort the array
        // calculate sum with every number array indexed number
        // sum + k > num[j] (Max number) * number of elements
            //continue;
        // simple reduce elements from ith side untill sum + k > (max * number of elements)
        // Calculate number of elements at every step
        // return number count
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int resCount = -1;
        int n = nums.length;
        long sum = 0;
        int i = 0;
        
        for(int j=0; j<n; j++) {
            sum += nums[j];
            while(sum + k < (1l * nums[j] * (j-i+1))) {
                sum -= nums[i];
                i++;
            }
            resCount = Math.max(resCount, j-i+1);
        }
        return resCount;
    }
}