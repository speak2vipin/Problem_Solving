class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        
        int N = nums.length;
        PriorityQueue<int[]> maxHeap = 
            new PriorityQueue<int[]>((x,y)->y[0]-x[0]);
        
        int sum = nums[0];
        maxHeap.offer(new int[]{nums[0], 0});
        for(int i=1; i<N; i++) {
            while(i-maxHeap.peek()[1]>k) {
                maxHeap.poll();
            }
            int curr = Math.max(maxHeap.peek()[0],0) + nums[i];
            maxHeap.offer(new int[]{curr, i});
            sum = Math.max(sum, curr);
        }
        return sum;
    }
}