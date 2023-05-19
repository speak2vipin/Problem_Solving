class Solution {
    
    int color[] = null;
    Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
    public boolean isBipartite(int[][] graph) {
        
        int N = graph.length;
        color = new int[N];
        Arrays.fill(color, -1);
        for(int i=0; i<N; i++) {
            for(int edge : graph[i]) {
                adj.computeIfAbsent(i, val->new ArrayList<Integer>()).add(edge);
            }
        }
        for(int i=0; i<N; i++) {
            if(color[i]==-1) {
                color[i] = 0;
                if(!dfs(i)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    boolean dfs(int node) {
        if(adj.get(node)!=null) {
            for(Integer neighbor : adj.get(node)) {
                if(color[neighbor]==-1) {
                    color[neighbor] = 1 ^ color[node];
                    if(!dfs(neighbor)) {
                        return false;
                    }     
                } else if(color[neighbor] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}