class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y) -> Integer.compare(y, x));
        
        int n = queries.length;
        int res[] = new int[n];
        int dist = 0;
        int size = 0;
        int val = -1;
        
        for(int i=0; i<n; i++) {
            dist = Math.abs(queries[i][0]) + Math.abs(queries[i][1]);
            pq.offer(dist);
            size = pq.size();
            if(size>k) {
                pq.poll();
                size--;
            }
            if(size==k) {
                val = pq.peek();
            }
              
            res[i] = val;
        }
        return res;
    }
}