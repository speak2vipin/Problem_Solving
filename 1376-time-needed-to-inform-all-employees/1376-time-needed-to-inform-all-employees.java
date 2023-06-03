class Solution {
    
   Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
    int res = Integer.MIN_VALUE;
	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        for(int i=0; i<n; i++) {
            if(manager[i]!=-1)
                adj.computeIfAbsent(manager[i], val->new ArrayList<>()).add(i);
        }
 
        dfs(headID, informTime, 0);
        return res;  
    }
    
    int dfs(int node, int[] informTime, int time) {
        res = Math.max(res, time);
        ArrayList<Integer> subordinates = adj.getOrDefault(node,new ArrayList<Integer>());
        for(Integer subordinate : subordinates) {
            dfs(subordinate,informTime, time + informTime[node]);
        }
        return time;
    }
}