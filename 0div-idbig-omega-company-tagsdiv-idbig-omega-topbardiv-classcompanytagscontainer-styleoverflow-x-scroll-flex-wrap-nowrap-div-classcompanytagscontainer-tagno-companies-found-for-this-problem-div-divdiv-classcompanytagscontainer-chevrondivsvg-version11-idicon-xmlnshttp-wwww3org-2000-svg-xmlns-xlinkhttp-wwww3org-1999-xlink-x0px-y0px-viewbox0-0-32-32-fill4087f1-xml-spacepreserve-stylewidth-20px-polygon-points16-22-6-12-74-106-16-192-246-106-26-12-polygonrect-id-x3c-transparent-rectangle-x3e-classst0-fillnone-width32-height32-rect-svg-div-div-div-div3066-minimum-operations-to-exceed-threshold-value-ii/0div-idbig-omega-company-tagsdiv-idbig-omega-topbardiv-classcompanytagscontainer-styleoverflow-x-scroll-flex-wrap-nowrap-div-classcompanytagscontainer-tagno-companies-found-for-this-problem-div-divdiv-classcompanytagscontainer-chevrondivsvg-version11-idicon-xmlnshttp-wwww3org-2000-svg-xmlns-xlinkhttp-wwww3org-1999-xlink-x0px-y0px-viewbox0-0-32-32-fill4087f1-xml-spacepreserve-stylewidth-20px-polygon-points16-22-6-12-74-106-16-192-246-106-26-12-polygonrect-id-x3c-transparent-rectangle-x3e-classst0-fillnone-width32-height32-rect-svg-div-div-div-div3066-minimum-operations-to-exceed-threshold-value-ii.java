class Solution {
    public int minOperations(int[] nums, int k) {
        if(nums.length<2) {
            return 0;
        }
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        for(int num : nums) {
            pq.offer((long)num);
        }
        int result = 0;
        while(pq.peek()<k && pq.size()>1) {
            Long min = pq.poll();
            Long max = pq.poll();
            min = min*2 + max;
            pq.offer(min);
            result++;
        }
        return pq.peek()>=k?result:0;
        
    }
}