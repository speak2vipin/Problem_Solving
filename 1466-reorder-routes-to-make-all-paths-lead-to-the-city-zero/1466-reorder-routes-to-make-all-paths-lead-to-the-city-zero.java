class Solution {
    Map<Integer, ArrayList<Integer>> adj = null;
    boolean vst[] = null;
    int count = 0;
    public int minReorder(int n, int[][] connections) {
        adj = new HashMap<>();
        vst = new boolean[n];
        for(int connection[] : connections) {
            adj.computeIfAbsent(connection[0], val->new ArrayList<Integer>()).add(connection[1]);
            adj.computeIfAbsent(connection[1], val->new ArrayList<Integer>()).add((-1)*connection[0]);
        }
        dfs(0);
        return count;
    }
    
    void dfs(int node) {
        vst[node] = true;
        ArrayList<Integer> neighbours = adj.getOrDefault(node, new ArrayList<Integer>());
        for(Integer neighbour : neighbours) {
            if(!vst[Math.abs(neighbour)]) {
                count += neighbour<0 ? 0 : 1;
                dfs(Math.abs(neighbour));
            } 
        } 
    }
}