class Solution {
    // Logic:
        // TRy to find a block with minimum second value so that second block can be considered as soon as possible
        // Sort Array by second value
        // find pairs count which are increasing
    
    public int findLongestChain(int[][] pairs) {        
	        Arrays.sort(pairs, (x,y) -> (x[1] - y[1]));
	        int n = pairs.length;
	        int j = 1;
	        int prev = pairs[0][1];
	        int count = 1;
	        while(j<n) {
	            if(pairs[j][0]>prev) {
	                count++;
	                prev = pairs[j][1];
	            }
	            j++;
	        }
	        return count;  
    }
}