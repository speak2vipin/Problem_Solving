class Solution {
    public boolean isPowerOfThree(int n) {
        //Maximum 3's power exist for int primitive is Math.pow(3,19)
        // if u do Math.pow(3,20), then int number will overflow.
        return (Math.pow(3,19)%n==0 && n>0);
	
    }
}