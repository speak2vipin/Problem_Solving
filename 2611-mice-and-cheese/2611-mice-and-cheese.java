class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int N = reward1.length;
        int ans = 0;
        for(int cheese : reward2) {
            ans = ans+cheese;
        }
        PriorityQueue<Integer>minHeap = new PriorityQueue<Integer>();
        for(int i=0; i<N; i++) {
            minHeap.offer(reward1[i] - reward2[i]);
            if(minHeap.size()>k) {
                minHeap.poll();
            }
        }
        while(minHeap.size()>0) {
            ans = ans + minHeap.poll(); 
            // rewards[2] - (rewards[1] - rewards[2]) = rewards[1]
        }
        return ans;
    }
}