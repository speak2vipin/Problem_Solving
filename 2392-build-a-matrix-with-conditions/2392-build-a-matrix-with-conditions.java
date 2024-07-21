class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        
        List<Integer> orderRows = topoSort(rowConditions, k);
        List<Integer> orderCols = topoSort(colConditions, k);
        if(orderRows.isEmpty() || orderCols.isEmpty()) {
            return new int[0][0];
        }
        int matrix[][] = new int[k][k];
        
        for(int i=0; i<k; i++) {
            for(int j=0; j<k; j++) {
                if(orderRows.get(i).equals(orderCols.get(j))) {
                    matrix[i][j] = orderRows.get(i);
                }
            }
        }
        return matrix;
    }
    
    private List<Integer> topoSort(int edge[][], int n) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for(int e[] : edge) {
            adj.computeIfAbsent(e[0], val->new ArrayList<Integer>()).add(e[1]);
        }
        
        List<Integer> order = new ArrayList<>();
        boolean visit[] = new boolean[n+1];
        for(int i=1; i<=n; i++) {
            boolean path[] = new boolean[n+1];
            if(!visit[i] && dfs(adj, i, visit, path, order)) {
                return new ArrayList<>();
            }
        }
        Collections.reverse(order);
        return order;
        
    }
    
    boolean dfs(Map<Integer, ArrayList<Integer>> adj, 
                int source, boolean visit[], 
                boolean path[], List<Integer> order) {
        visit[source] = true;
        path[source] = true;
        for(Integer neighbor : adj.getOrDefault(source, new ArrayList<>())) {
            if(path[neighbor]) {
                return true;
            } else if(!visit[neighbor] && dfs(adj, neighbor, visit, path, order)) {
                return true;
            }
        }
        path[source] = false;
        order.add(source);
        return false;
    }
}