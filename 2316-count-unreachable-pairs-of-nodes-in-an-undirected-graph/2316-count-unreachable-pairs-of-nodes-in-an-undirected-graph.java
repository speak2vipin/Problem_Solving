class Solution {
    HashMap<Integer, List<Integer>> adj = null;
    boolean vst[] = null;
    long count = 1;
    public long countPairs(int n, int[][] edges) {
        adj = new HashMap<>();
        vst = new boolean[n];
        for(int[] edge : edges) {
            adj.computeIfAbsent(edge[0], val->new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], val->new ArrayList<Integer>()).add(edge[0]);
        }
        long ans = 0;
        long totalNode = 0;
        for(int i=0; i<n; i++) {
            if(!vst[i]) {
                dfs(i);
                ans += totalNode*count;
                totalNode += count;
                count = 1;
            }
        }
        return ans;
    }
    
    void dfs(int node) {
        vst[node] = true;
        if(adj.get(node)!=null) {
            for(int neighbour : adj.get(node)) {
                if(!vst[neighbour]) {
                    dfs(neighbour);
                    count++;
                }
            }
        }
    }
}