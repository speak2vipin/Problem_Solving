class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((A,B)->A[1]-B[1]);
        
        boolean visit[] = new boolean[n];
        HashMap<Integer, Integer> distanceMap = new HashMap<>();
        int total = 0;
        pq.offer(new int[]{0, 0});
        
        while(!pq.isEmpty()) {
            int top[] = pq.poll();
            int u = top[0];
            int w = top[1];
      
            if(!visit[u]) {
            	total += w;
                visit[u] = true;
                for(int j=0; j<n; j++) {
                    int newDist = Math.abs(points[u][0] - points[j][0]) + Math.abs(points[u][1] - points[j][1]);
                    if(!visit[j] && distanceMap.getOrDefault(j, Integer.MAX_VALUE)>=newDist) {
                        pq.offer(new int[]{j, newDist});
                        distanceMap.put(j, newDist);
                    }
                }
            }
        }
        return total;
    
    }
}