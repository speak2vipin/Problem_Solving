class Solution {
    public int[] shuffle(int[] nums, int n) {      
              
        // 1 <= nums[i] <= 10^3 i.e 1000 would be within 11111 11111 in binary 
        // i.e. Not more than that.
        for(int i=n; i<2*n; i++) {
        	int temp = nums[i]<<10;		// Number will left shift to 10 digits
            nums[i-n] = nums[i-n] | temp;	// Or'ed it with nums[i-n] 
        }
        int calculateFactors = (int)Math.pow(2, 10)-1;	
        // This would be 00000 00000 11111 11111
        for(int i=n-1; i>-1; i--) {
        	int first = nums[i] & (calculateFactors);
			int second = nums[i] >> 10;
			nums[2 * i] = first; // Number will right shift to 10 digits
			nums[2 * i + 1] = second; // Nullify the sets bits which are set post 10 digits
		}
        
        return nums;
        }
}