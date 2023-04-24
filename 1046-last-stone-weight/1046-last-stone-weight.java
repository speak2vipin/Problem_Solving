class Solution {
    // Logic
    // Take MaxHeap
    // Enqueue all stones in it 
    // Take max two stone
    // If they are not equal insert (max-secondMax)
    // Mark max = 0
    // return max.
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int stone : stones) {
            pq.offer(stone);
        }
        int max  = 0;
        int secondMax = 0;
        while(!pq.isEmpty()) {
            max = pq.poll();
            if(pq.isEmpty()) {
                break;
            }
            secondMax = pq.poll();
            if(max>secondMax) {
                pq.offer(max-secondMax);
            } else {
                max = 0;
            }
        }
        return max;
    }
}