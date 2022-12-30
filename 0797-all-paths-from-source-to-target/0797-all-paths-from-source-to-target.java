class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>>ans = new ArrayList<List<Integer>>();
        List<Integer>current = new ArrayList<Integer>();
        current.add(0);
        int len = graph.length;
        dfs(0, current, graph, len-1, ans);
        return ans;
    }
    
    private void dfs(int src, List<Integer>current, int graph[][], int dest, List<List<Integer>>ans) {
        if(src==dest) {
            ans.add(new ArrayList(current));
            return ;
        }
        for(int nodes : graph[src]) {
            current.add(nodes);
            dfs(nodes, current, graph, dest, ans);
            current.remove(current.size()-1);
        }
        
    }
    
}