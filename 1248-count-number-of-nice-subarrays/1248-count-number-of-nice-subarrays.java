class Solution {
    // Logic : Sliding window approach
    // A) Odd varible store number of Odd Numbers.
    // B) Count varible is to be used to add numbers in case of array 
    // having even number at any end in array.
    // Keep on adding count in case of any even number in right
    // In case of getting odd number reinitiate it to 0 (i.e. count)
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