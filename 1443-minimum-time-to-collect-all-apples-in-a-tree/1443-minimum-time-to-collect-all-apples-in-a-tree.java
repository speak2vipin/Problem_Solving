class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>>map = new HashMap<Integer, List<Integer>>();
        int N = edges.length;
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            map.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            map.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }
        return dfs(0, -1, map, hasApple);
        
        
        
    }
    
    public int dfs(int node, int parent, Map<Integer, List<Integer>>map, List<Boolean> hasApple) {
        if(!map.containsKey(node)) {
            return 0;
        }
        int totalTime = 0; int childTotalTime = 0;
        for(int child : map.get(node)) {
            if(child==parent) {
                // Take care of it or else it would be infinity loop
                continue;
            }
            childTotalTime = dfs(child, node, map, hasApple);
            if(childTotalTime>0 || hasApple.get(child)) {
                totalTime += childTotalTime+2;
            }
        }
        return totalTime;
    } 
}