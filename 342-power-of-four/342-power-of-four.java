class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==0) {
            return false;
        }
	        long temp =0;
	        int count =0;
	        while(temp<n) {
	            temp = (long)(Math.pow(4,count));
	            count++;
	        }
	        return temp==n;
    }
}