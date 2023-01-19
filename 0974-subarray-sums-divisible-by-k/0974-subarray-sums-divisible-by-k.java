class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int N = nums.length;
        int prefixMod[] = new int[N];
        int prefix = 0;
        int remainder = 0;
        // Evaluate remainder prefixSum array
        for(int i=0; i<N; i++) {
            prefix+=nums[i];
            remainder = prefix%k;     
            if(remainder < 0) {
            	remainder = (remainder+k)%k;
            }
            prefixMod[i] = remainder;   
        }
        int count=0;
        int modgroup[] = new int[k];
        
        for(int i=0; i<N; i++) {
            // If prefixMod is zero means that subArray has sum which is divisible 
            if(prefixMod[i]==0) {
                count++;
            }
            // Check if we have same remainder i.e. remainder diff between those two index would be 0
            count += modgroup[prefixMod[i]];
            modgroup[prefixMod[i]] = modgroup[prefixMod[i]]+1;
        }
        return count;
    
    }
}