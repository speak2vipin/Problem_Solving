class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int N = nums.length;
        int st = 0;
        int en = 0;
        
        for(int i=0; i<N; i=en) {
            String tempRes = "";
            st = i;
            en = i;
            while(en+1<N && nums[en]+1==nums[en+1]) {
                en++;
            }
            if(st == en) {
                tempRes += nums[st]; 
            } else {
                tempRes = nums[st] + "->" + nums[en];
            }
            en++;
            res.add(tempRes);
        }
        
        return res; 
    }
}