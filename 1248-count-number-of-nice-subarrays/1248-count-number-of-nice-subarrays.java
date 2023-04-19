class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int N = nums.length;
        int i=0, j=0;
        int count = 0;
        int total = 0;
        while(j<N) {
            if((nums[j]%2)!=0) {
                k--;
                count = 0;
            }
            if(k==0) {
                while(k==0 && i<=j) {
                    if((nums[i++]%2)!=0) {
                         k++;
                    }
                    count++;
                }
            } 
            total += count;
            j++;
        } 
        return total;
    }
}