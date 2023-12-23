class Solution {
    public long minimumCost(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
	    int med = nums[N/2];
        int palindromeLess = palindromeLess(med);
        int palindromeMore = palindromeMore(med);
        return Math.min(calculateCost(nums, palindromeLess), calculateCost(nums, palindromeMore));
	    }
    
        int palindromeLess(int num) {
            while(!check(num)) {
                num--;
            }
            return num;
        }
        int palindromeMore(int num) {
            while(!check(num)) {
                num++;
            }
            return num;
        }
    
        boolean check(int originalNum) {
            int temp = 0;
            int num = originalNum;
            while(num>0) {
                temp = temp*10 + (num%10);
                num = num/10;
            }
            return temp==originalNum;
        }
    
	    
	    static long calculateCost(int nums[], int p) {
	        long sum = 0l;
	        //long p = Long.parseLong(palindrome);
	        for(int num : nums) {
	            sum += Math.abs(p-num);
	        }
	        return sum;
	    }
}