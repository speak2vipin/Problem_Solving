class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for(int r []: relations) {
            int source = r[0];
            int dest = r[1];
            adj.computeIfAbsent(source, val -> new ArrayList<Integer>()).add(dest);
        }
        int indegree[] = new int[n+1];
        
        for(int r[] : relations) {
            int source = r[0];
            int dest = r[1];
            indegree[dest]++;
        }
        Queue<Integer> qe = new LinkedList<>();
        int maxTime[] = new int[n+1];
        for(int i=1;i<n+1; i++) {
            if(indegree[i]==0) {
                qe.offer(i);
                maxTime[i] = time[i-1];
            }
        }
        while(!qe.isEmpty()) {
            int top = qe.poll();
            ArrayList<Integer> neighbors = 
                adj.getOrDefault(top, new ArrayList<Integer>());
            for(int neighbor : neighbors) {
                maxTime[neighbor] = Math.max(maxTime[neighbor], 
                                             time[neighbor-1] + maxTime[top]);
                indegree[neighbor]--;
                if(indegree[neighbor]==0) {
                    qe.add(neighbor);
                }
            } 
        }
        int ans = Integer.MIN_VALUE;
        for(int i=1; i<n+1; i++) {
            ans = Math.max(ans, maxTime[i]);
        }
        return ans;
    }
}