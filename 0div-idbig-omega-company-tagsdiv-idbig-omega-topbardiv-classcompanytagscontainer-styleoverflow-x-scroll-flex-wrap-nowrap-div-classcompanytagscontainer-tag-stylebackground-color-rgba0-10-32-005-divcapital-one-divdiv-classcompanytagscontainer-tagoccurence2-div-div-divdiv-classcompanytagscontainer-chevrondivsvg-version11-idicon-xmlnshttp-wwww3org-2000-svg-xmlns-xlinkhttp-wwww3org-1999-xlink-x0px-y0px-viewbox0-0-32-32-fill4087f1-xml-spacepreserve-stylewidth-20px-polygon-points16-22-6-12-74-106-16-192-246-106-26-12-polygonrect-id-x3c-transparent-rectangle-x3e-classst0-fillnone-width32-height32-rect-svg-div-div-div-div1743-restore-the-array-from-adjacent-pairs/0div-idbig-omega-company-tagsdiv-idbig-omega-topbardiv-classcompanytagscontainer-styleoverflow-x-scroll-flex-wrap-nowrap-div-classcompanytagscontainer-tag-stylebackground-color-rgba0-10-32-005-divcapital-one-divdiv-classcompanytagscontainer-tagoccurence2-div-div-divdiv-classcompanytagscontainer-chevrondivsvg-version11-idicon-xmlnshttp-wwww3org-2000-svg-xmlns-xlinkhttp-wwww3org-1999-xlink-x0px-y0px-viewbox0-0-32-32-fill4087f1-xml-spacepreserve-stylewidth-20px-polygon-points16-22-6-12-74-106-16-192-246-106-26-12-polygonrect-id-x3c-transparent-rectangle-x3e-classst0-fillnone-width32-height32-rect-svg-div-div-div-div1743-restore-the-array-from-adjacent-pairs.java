class Solution {
    Map<Integer, ArrayList<Integer>> adj = null;
    public int[] restoreArray(int[][] adjacentPairs) {
        int N = adjacentPairs.length;
        adj = new HashMap<>();
        for(int a[] : adjacentPairs) {
            adj.computeIfAbsent(a[0], val->new ArrayList<Integer>()).add(a[1]);
            adj.computeIfAbsent(a[1], val->new ArrayList<Integer>()).add(a[0]);
        }
        Integer start = null;
        Map<Integer, Boolean> visit = new HashMap<>();
        for(Integer key : adj.keySet()) {
            if(adj.get(key).size()==1) {
                start = key;
                break;
            }
        }
        int ans[] = new int[N+1];
        List<Integer> ansList = new ArrayList<>();
        ansList.add(start);
        
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