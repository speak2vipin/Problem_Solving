class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer>map = new HashMap<>();
        int total = 0;
        int len = 0;
        for(int i=0; i<n; i++) {
            total += nums[i]==0?-1:1;
            if(total==0) {
                len = Math.max(len, i+1);
            }
            if(map.get(total)==null) {
                map.put(total, i);
            } else {
                len = Math.max(len, i-map.get(total));
            }
        }
        return len;
        
    }
}