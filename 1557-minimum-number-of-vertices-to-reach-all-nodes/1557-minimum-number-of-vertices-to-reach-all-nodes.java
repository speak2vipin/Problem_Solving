class Solution {
    // Logic:
    // Create a visit array
        // Mark node visited by using edge matrix. So mark destination node as visited.
    // In last include all the nodes which are note visited in res list.
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean isConnectionExist[] = new boolean[n];
        for(List<Integer> edge : edges) {
            isConnectionExist[edge.get(1)] = true;
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(!isConnectionExist[i]) {
                res.add(i);
            }  
        }
        return res;
    }
}