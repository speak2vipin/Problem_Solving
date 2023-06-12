class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int N = nums.length;
        if(N==0) {
            return res;
        } 
        int st = 0;
        int en = 0;
        String tempRes = "";
        for(int i=1; i<N; i++) {
            if(nums[en]+1 == nums[i]) {
                en = i;
            } else {
                if(en==st) {
                    tempRes = tempRes + nums[st];
                } else {
                    tempRes = nums[st] + "->" + nums[en];
                }
                res.add(tempRes);
                tempRes = "";
                st = i;
                en = i;
            }
        }
        if(en==st) {
            tempRes = tempRes + nums[st];
        } else {
            tempRes = nums[st] + "->" + nums[en];
        }
        res.add(tempRes);
        
        return res; 
    }
}