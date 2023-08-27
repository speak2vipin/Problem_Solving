class Solution {
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