class Solution {
   int longestPath = 1;
    
   public int longestPath(int[] parent, String s) {
        Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
        int N = parent.length;
        
        for(int i=1; i<N; i++) {
            adj.computeIfAbsent(parent[i], val -> new ArrayList<Integer>()).add(i);
        }
        dfs(adj, 0, s);
        return longestPath;
        
    }
    
    int dfs(Map<Integer, List<Integer>> adj, int index, String S) {
       
        if(!adj.containsKey(index)) {
            return 1;
        }
        int longestChain = 0;
        int secondLongestChain = 0;
        List<Integer> l = adj.get(index);
        for(Integer temp : l) {
            int childLongestChain = dfs(adj, temp, S);
            if(S.charAt(temp)==S.charAt(index)) {
                continue;
            } 
            if(childLongestChain>longestChain) {
                secondLongestChain = longestChain;
                longestChain = childLongestChain;
            } else if(childLongestChain> secondLongestChain) {
                secondLongestChain = childLongestChain;
            }
        }
        longestPath = Math.max(longestPath, 
                               longestChain + secondLongestChain +1);
        return longestChain + 1;
        
    }
}