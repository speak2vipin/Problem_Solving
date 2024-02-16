class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int a : arr) {
            freq.put(a, freq.getOrDefault(a, 0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x,y)->x[1]-y[1]);
        for(int key : freq.keySet()) {
            pq.offer(new int[]{key, freq.get(key)});
        }
        while(k>0 && k>=pq.peek()[1]) {
            k -= pq.poll()[1]; 
        }
        return pq.size();
        
    }
}