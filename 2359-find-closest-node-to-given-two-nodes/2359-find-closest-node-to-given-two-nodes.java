class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int dist1[] = new int[n];
        int dist2[] = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        
        bfs(node1, edges, dist1); 
        bfs(node2, edges, dist2);
        int ans = -1;
        int minDistance = Integer.MAX_VALUE;
    
        for(int i=0; i< n; i++) {
            if(dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE) {
                if(minDistance>Math.max(dist1[i], dist2[i])) {
                    minDistance = Math.max(dist1[i], dist2[i]);
                    ans = i;
                }    
            }
        }
        return ans;
    }
    
    public void bfs(int st, int edge[], int dist[]) {
        Queue<Integer> qe = new LinkedList<Integer>();
        qe.offer(st);
        boolean visit[] = new boolean[edge.length];
        dist[st] = 0;
        visit[st] = true;
        while(!qe.isEmpty()) {
            int top = qe.poll();
            if(edge[top]!=-1 && !visit[edge[top]]) {
                dist[edge[top]] = dist[top]+1;
                visit[edge[top]] = true;
                if(edge[edge[top]]!=-1) {
                    qe.offer(edge[top]);
                }
            }
        }
    }
}