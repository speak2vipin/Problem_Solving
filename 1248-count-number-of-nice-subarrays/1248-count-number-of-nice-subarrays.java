class Solution {
    // Logic
    // 
    public int numberOfSubarrays(int[] nums, int k) {
        int N = nums.length;
        int i=0, j=0;
        int count = 0;
        int total = 0;
        int odd = 0;
        while(j<N) {
            if((nums[j]%2)!=0) {
                odd++;
                count = 0;
            }
           
            while(odd==k && i<=j) {
                if((nums[i++]%2)!=0) {
                    odd--;
                }
                count++;
            }
             
            total += count;
            j++;
        } 
        return total;
    }
}