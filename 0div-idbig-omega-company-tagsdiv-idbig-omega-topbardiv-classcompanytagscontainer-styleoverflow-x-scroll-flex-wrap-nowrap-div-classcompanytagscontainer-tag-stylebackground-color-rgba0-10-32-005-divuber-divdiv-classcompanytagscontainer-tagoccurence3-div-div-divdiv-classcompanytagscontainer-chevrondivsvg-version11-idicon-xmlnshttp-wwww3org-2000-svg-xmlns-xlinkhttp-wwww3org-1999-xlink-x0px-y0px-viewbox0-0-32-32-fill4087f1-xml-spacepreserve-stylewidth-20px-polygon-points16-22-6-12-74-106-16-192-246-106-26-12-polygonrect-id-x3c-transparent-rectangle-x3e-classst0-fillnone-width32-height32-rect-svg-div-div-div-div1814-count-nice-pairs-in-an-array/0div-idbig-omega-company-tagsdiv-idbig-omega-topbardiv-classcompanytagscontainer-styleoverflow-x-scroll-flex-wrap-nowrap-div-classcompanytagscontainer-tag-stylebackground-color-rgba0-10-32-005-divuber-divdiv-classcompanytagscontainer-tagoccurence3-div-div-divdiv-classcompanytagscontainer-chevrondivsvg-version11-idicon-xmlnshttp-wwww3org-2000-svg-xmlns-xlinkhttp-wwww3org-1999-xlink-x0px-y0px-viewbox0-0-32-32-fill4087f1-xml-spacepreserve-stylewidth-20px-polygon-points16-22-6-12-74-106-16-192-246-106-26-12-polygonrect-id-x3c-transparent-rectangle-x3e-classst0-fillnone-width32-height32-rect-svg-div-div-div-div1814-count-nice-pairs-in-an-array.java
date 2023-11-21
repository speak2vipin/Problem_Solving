class Solution {
    public int countNicePairs(int[] nums) {
        int count = 0;
        int n = nums.length;
        Map<Long, Long> temp = new HashMap<>();
        for(int i=0; i<n; i++) {
            long reverse = findReverse(nums[i]);
            long sum = nums[i]-reverse;
            count = (int)((count + temp.getOrDefault(sum, 0l))%1000_000_007);
            temp.put(sum, temp.getOrDefault(sum, 0l)+1);
        }
        return count;
    }
    
    long findReverse(int num) { 
	    StringBuffer sb = new StringBuffer();
	    sb.append(num);
	    return Long.parseLong(sb.reverse().toString());
	}
}