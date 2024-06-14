class Solution {
    public int minIncrementForUniqueMySolution(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        Queue<Integer> qe = new ArrayDeque<>();
       // int min = num[0];
        for(int num : nums) {
            if(set.contains(num)) {
                qe.offer(num);
            }
            set.add(num);
        }
        
        int ans = 0;
        int temp = -1;
        while(!qe.isEmpty()) {
            int top = qe.poll();
            if(temp<top) {
                temp = top;
            }
            while(set.contains(temp)) {
                temp++;
            }
            ans += temp-top;
            set.add(temp);
        }
        return ans;
    }
    
    public int minIncrementForUnique(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++) {
            if(nums[i]<=nums[i-1]) {
                count += nums[i-1] - nums[i] + 1;
                nums[i] = nums[i] + (nums[i-1] - nums[i] + 1);
            }
        }
        return count;
    } 
}