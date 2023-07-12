class Solution {
    Map<Integer, ArrayList<Integer>> adj = null;
    boolean visit[] = null;
    boolean path[] = null;
    int[] ans = null;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        adj = new HashMap<>();
        int n = graph.length;
        visit = new boolean[n];
        path = new boolean[n];
        ans = new int[n];
        for(int i=0; i<n; i++) {
            for(int node : graph[i]) {
            		adj.computeIfAbsent(i, val->new ArrayList<Integer>()).add(node);
            }
        }
        for(int i=0; i<n; i++) {
            dfs(i);
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(ans[i]==1) {
                res.add(i);
            }
        }
        return res;
    }
    
    boolean dfs(int node) {
        if(path[node]) 
            return true;
        if(visit[node]) {
            return false;
        }
        
        path[node] = true;
        visit[node] = true;
        if(adj.get(node)!=null) {
            ArrayList<Integer> neighbors = adj.get(node);
            for(Integer neighbor : neighbors) {
                if(dfs(neighbor)) {
                    return true;
                }
            }
        }
        path[node] = false;
        ans[node]=1;
        return false;
    }
}