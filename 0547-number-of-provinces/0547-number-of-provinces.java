class Solution {
    // Logic:
        // Simple DFS will work here.
        // Build adj matrix
        // visited matrix will take care of visited nodes.
    Map<Integer, ArrayList<Integer>> adj = null;
    public int findCircleNum(int[][] isConnected) {
        adj = new HashMap<>();
        int N = isConnected.length;
        for(int i=0; i<N; i++) {
           // int temp[] = isConnected[i];
            for(int j=0; j<N; j++) {
                if(i==j) {
                    continue;
                } else if(isConnected[i][j]==1) {
                    adj.computeIfAbsent(i, val->new ArrayList<Integer>()).add(j);
                    adj.computeIfAbsent(j, val->new ArrayList<Integer>()).add(i);
                }
            }
        }
        int res = 0;
        boolean visited[] = new boolean[N];
        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                res++;
                dfs(i, visited);
            }
        
        }
        return res;
    }
    
    void dfs(int source, boolean visited[]) {
        visited[source] = true;
        for(Integer node : adj.getOrDefault(source, new ArrayList<Integer>())) {
            if(!visited[node]) {
                dfs(node, visited);
            }
        }
    }
}