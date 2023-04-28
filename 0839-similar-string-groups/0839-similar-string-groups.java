class Solution {
    Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
    
    public int numSimilarGroups(String[] strs) {
        int N = strs.length;
        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                if(isSimilar(strs[i], strs[j])) {
                    adj.computeIfAbsent(i, val->new ArrayList<Integer>()).add(j);
                    adj.computeIfAbsent(j, val->new ArrayList<Integer>()).add(i);
                }
            }
        }
        boolean visit[] = new boolean[N];
        for(int i=0; i<N; i++) {
            if(!visit[i]) {
                count++;
                dfs(i, visit);
            }
            
        }
        return count;
    }
    
    void dfs(int node, boolean visit[]) {
        visit[node] = true;
        if(adj.get(node)!=null) {
            ArrayList<Integer> neighbours = adj.get(node);
            for(Integer neighbour : neighbours) {
                if(!visit[neighbour]) {
                    dfs(neighbour, visit);
                }
            }
        } 
    }
    
    boolean isSimilar(String R, String S) {
        int diff = 0;
        for(int i=0; i<R.length(); i++) {
            if(R.charAt(i)!=S.charAt(i)) {
                diff++;
            }
        }
        return diff==0 || diff==2; 
    }
}