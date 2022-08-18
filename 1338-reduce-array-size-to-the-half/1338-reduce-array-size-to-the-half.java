class Solution {
    public int minSetSize(int[] arr) {
        
        int count = 0, n = arr.length/2;
        Map<Integer, Integer> map = new HashMap<>();      // frequency map
        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 0)+1); 
        }
        if(map.size()==1) return 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(map.size(), Collections.reverseOrder());          //maxHeap
        for(Integer i : map.values()) {
            pq.offer(i);
        }
        while(!pq.isEmpty() && n>0) { 
            n-=pq.poll();
            count++;
        }
        return count;
        
        
    }
}