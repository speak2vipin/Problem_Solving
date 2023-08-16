class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        // Used to get the Max element
        PriorityQueue<Integer> pq = new  PriorityQueue<Integer>(Collections.reverseOrder());
        int n = nums.length;
        int res[] = new int[n-k+1];
        int i=0;
        // Will be used to maintain the frequency of every element
        Map<Integer, Integer> freq = new HashMap<>();
        
        for(i=0; i<k; i++) {
            pq.offer(nums[i]);
            freq.put(nums[i], freq.getOrDefault(nums[i], 0)+1);
        }
        
        i--;    // Simply to consider very first sliding window
        while(i<n) {
            int top = pq.peek();
            if(freq.get(top)!=null) {
                res[i-k+1] = top;
            } else {
                // If freq is null then remove it from PriorityQueue
                pq.poll();
                continue;
            }
            
            int last = nums[i-k+1];
            // Reduce the frequency of last element if it's 1 then remove it from frequency map
            if(freq.get(last)==1) {
                freq.remove(last);
            } else {
                freq.put(last, freq.get(last)-1);
            }
            // Increase the frequency by 1 of next element
            if(i+1<n) {
                freq.put(nums[i+1], freq.getOrDefault(nums[i+1], 0)+1);
                pq.offer(nums[i+1]);
            }
            i++;
        }
        return res;
    }
}