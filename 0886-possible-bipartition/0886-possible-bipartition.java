class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int[] input : dislikes) {
            int a1 = input[0]; int a2 = input[1];
            map.computeIfAbsent(a1, value -> new ArrayList<Integer>()).add(a2);
            map.computeIfAbsent(a2, value -> new ArrayList<Integer>()).add(a1);
        }
        int color[] = new int[n+1];
        Arrays.fill(color, -1);
        for(int i=1; i<=n; i++) {
            if(color[i]==-1) {
                if(!bfs(i, map, color)) {
                    return false;
                }
            }            
        }
        return true;
    }
    
    public boolean bfs(int source, Map<Integer, List<Integer>> adj, 
                       int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        color[source] = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            if(!adj.containsKey(node)) {
                continue;
            }
            for(int neighbor : adj.get(node)) {
                if(color[neighbor] == color[node]) {
                    return false;
                }
                if(color[neighbor]==-1) {
                    color[neighbor] = 1-color[node];
                    q.add(neighbor);
                }
            }
        }
        return true;
    }
}