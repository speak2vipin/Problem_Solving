class Solution {
    public long maximumTripletValueWithNCube(int[] nums) {
        int n = nums.length;
        long res = Long.MIN_VALUE;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int k=j+1; k<n; k++) {
                    res = Math.max(res, (nums[i]-nums[j])*1l*nums[k]);
                }
            }
        }
        return res<0?0:res;
    }
    public long maximumTripletValue(int[] nums) {
        long res = 0, maxab = 0, maxa = 0;
        for(int num : nums) {
            res = Math.max(res, 1l*maxab*num);
            maxab = Math.max(maxab, maxa-num);
            maxa = Math.max(maxa, num);
        }
        
        return res;
    }
}