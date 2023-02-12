class Solution {
    Map<Integer, ArrayList<Integer>> adj;
    long fuel;
    public long minimumFuelCost(int[][] roads, int seats) {
        adj = new HashMap<Integer, ArrayList<Integer>> ();
        for(int road[] : roads) {
            adj.computeIfAbsent(road[0], val->new ArrayList<Integer>()).add(road[1]);
            adj.computeIfAbsent(road[1], val->new ArrayList<Integer>()).add(road[0]);
        }
        dfs(0, -1, seats);
        return fuel; 
    }
    
    long dfs(int node, int parent, int seats) {
        
        int representative = 1;
        if(!adj.containsKey(node)) {
            return representative;
        }
        for(int neighbor : adj.get(node)) {
            if(neighbor!=parent) {
                representative += dfs(neighbor, node, seats);
            }
        }
        if(node !=0) {
            fuel += Math.ceil((double)representative/seats);
        }
        return representative;
    }
}