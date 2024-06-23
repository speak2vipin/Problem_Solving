class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int ans = 0;
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(
            (x,y) -> Integer.compare(x[0], y[0]));
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(
            (x,y) -> Integer.compare(y[0], x[0]));
       
        
        for(i=0; i<n; i++) {
            minHeap.offer(new int[]{nums[i], i});
            maxHeap.offer(new int[]{nums[i], i});
            
            while(Math.abs(maxHeap.peek()[0] - minHeap.peek()[0])>limit) {
                j = Math.min(maxHeap.peek()[1], minHeap.peek()[1]) + 1;
                while(maxHeap.peek()[1]<j) {
                    maxHeap.poll();
                }
                while(minHeap.peek()[1]<j) {
                    minHeap.poll();
                }
            }
            ans = Math.max(ans, i-j+1);
        }
        return ans;
    }
}