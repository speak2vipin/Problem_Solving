class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>
            ((x,y) -> ((x[0]==y[0]) ? Integer.compare(x[1], y[1]) : Integer.compare(x[0], y[0])));
        
        int n = nums.length;
        
        for(int i=0; i<n; i++) {
            minHeap.offer(new int[]{nums[i], i});
        }
        
        while(k>0) {
            int min[] = minHeap.poll();
            min[0] = min[0] * multiplier;
            minHeap.offer(min);
            k--;
        }
        
        int res[] = new int[n];
        
        while(!minHeap.isEmpty()) {
            int min[] = minHeap.poll();
            res[min[1]] = min[0];
        }
        return res;
    }
}