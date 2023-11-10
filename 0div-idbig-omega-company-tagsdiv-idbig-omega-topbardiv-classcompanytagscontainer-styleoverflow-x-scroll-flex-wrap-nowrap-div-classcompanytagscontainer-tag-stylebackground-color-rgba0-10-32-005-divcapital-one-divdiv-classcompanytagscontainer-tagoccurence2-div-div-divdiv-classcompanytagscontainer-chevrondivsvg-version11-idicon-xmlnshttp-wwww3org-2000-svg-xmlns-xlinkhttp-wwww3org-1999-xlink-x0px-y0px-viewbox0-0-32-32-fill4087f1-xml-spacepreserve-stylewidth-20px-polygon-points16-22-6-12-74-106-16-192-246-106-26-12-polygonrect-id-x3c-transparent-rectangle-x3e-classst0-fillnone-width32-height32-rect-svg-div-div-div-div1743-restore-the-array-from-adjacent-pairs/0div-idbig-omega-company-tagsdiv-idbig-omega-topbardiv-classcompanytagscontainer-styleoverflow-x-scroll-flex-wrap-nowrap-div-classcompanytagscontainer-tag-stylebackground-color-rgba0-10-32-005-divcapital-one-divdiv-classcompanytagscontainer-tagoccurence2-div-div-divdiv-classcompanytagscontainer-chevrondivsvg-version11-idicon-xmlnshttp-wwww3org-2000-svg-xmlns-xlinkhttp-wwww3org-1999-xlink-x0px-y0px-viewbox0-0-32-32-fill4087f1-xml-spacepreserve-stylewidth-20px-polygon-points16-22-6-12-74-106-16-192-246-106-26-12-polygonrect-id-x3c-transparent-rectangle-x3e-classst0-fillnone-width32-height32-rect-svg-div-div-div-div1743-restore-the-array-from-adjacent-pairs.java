// TC : O(N+E) for DFS
// SC : O(N)

class Solution {
    
    Map<Integer, ArrayList<Integer>> adj = null;
    public int[] restoreArray(int[][] adjacentPairs) {
        int N = adjacentPairs.length;
        adj = new HashMap<>();
        // Create Adjency Map
        for(int a[] : adjacentPairs) {
            adj.computeIfAbsent(a[0], val->new ArrayList<Integer>()).add(a[1]);
            adj.computeIfAbsent(a[1], val->new ArrayList<Integer>()).add(a[0]);
        }
        Integer start = null;
        // Since node can have negative values so to trace visited node have Map
        Map<Integer, Boolean> visit = new HashMap<>();
        // First find the node which should be starting point i.e. connection==1
        for(Integer key : adj.keySet()) {
            if(adj.get(key).size()==1) {
                start = key;
                break;
            }
        }
        // Values are N+1
        int ans[] = new int[N+1];
        List<Integer> ansList = new ArrayList<>();
        ansList.add(start);
        // Implmenet simple DFS
        dfs(start, visit, ansList);
        for(int i=0; i<ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
    
    void dfs(Integer node, Map<Integer, Boolean> visit, List<Integer> ansList ) {
        visit.put(node, true);
        for(Integer neighbour : adj.get(node)) {
            if(visit.get(neighbour)==null) {
                visit.put(node, true);
                ansList.add(neighbour);
                dfs(neighbour, visit, ansList);
            }
        }
    }
}