class Solution {
    Map<Integer, ArrayList<Integer>> adj = null;
    int count = Integer.MIN_VALUE;
    boolean vst[] = null;
    public int longestCycle(int[] edges) {
        int N = edges.length;
        adj = new HashMap<>();
        vst = new boolean[N];
        for(int i=0; i<N; i++) {
            if(!vst[i]) {
                Map<Integer, Integer>dist = new HashMap<>();
                dist.put(i,1);
                dfs(i, dist, edges);
            }
        }
        return (count == Integer.MIN_VALUE) ? -1 : count;
    }
    
    void dfs(int node, Map<Integer, Integer>dist, int edges[]) {
		vst[node] = true;
        int neighbour = edges[node];
		if (neighbour != -1) {
			if (!vst[neighbour]) {
				dist.put(neighbour, dist.get(node) + 1);
				dfs(neighbour, dist, edges);
			} else if (dist.get(neighbour)!=null) {
				count = Math.max(count, Math.abs(dist.get(neighbour) - dist.get(node)) + 1);
			}
		}  
    }
}