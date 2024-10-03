class Solution {
    public int minSubarray(int[] nums, int p) {

        int n = nums.length;
        int totalSum = 0;
        int ans = n;
        
        for(int st=0; st<n; st++) {
            totalSum = (totalSum + nums[st])%p;
        }
        int remainder = totalSum%p;
        
        if(remainder==0) {
            return 0;
        }
        HashMap<Integer, Integer> remainMap = new HashMap<>();
        remainMap.put(0, -1);
        int currSum = 0;
        for(int st=0; st<n; st++) {
            /*long sum = 0l;
            for(int en=st; en<n; en++) {
                sum += nums[en];
                if((totalSum-sum)%p==0) {
                    ans = Math.min(ans, en-st+1);
                }
            }*/
            
            currSum = (currSum + nums[st])%p;
            int needed = ((currSum - remainder + p) % p);
            if(remainMap.containsKey(needed)) {
                ans = Math.min(ans, st-remainMap.get(needed));
            }
            remainMap.put(currSum, st);
            
            
        }
        return ans==n?-1:ans;
        
    }
}