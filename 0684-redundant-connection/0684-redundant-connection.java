class Solution {
    int st = -1;
    int en = -1;
    
    Map<Integer, HashSet<Integer>>adj = null;
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        adj = new HashMap<>();
        
        for(int edge[] : edges) {
            if(dfs(edge[0], edge[1], new boolean[n+1])) {
                return edge;
            }
            adj.computeIfAbsent(edge[0], val->new HashSet<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], val->new HashSet<>()).add(edge[0]);
        }
        return null;
        
    }
    
    boolean dfs(int source, int target, boolean visit[]) {
        if(source==target) {
            return true;
        }
        visit[source] = true;
        
        HashSet<Integer> neighbors = adj.getOrDefault(source, new HashSet<>());
        
        for(Integer neighbor : neighbors) {
            if(!visit[neighbor] && dfs(neighbor, target, visit)) {
                return true;
            }
        }
        return false;
    }
}