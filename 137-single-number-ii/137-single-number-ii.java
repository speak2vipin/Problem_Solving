class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i=0; i<32; i++) {
            int count = 0;
            for(int temp : nums) {
                if(((temp>>i)&1)==1) {
                    count++;
                }
            }
            ans += (1<<i)*(count%3);
        }
        return ans;
    }
}