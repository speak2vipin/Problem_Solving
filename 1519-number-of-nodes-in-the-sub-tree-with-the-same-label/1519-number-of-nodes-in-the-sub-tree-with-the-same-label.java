class Solution {
    int ans[];
    String input = null;;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        input = labels;
        ans = new int[n];
        Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
        for(int[] edge : edges) {
            adj.computeIfAbsent(edge[0], (val -> new ArrayList<Integer>())).add(edge[1]);
            adj.computeIfAbsent(edge[1], (val -> new ArrayList<Integer>())).add(edge[0]);
        }
        helper(adj, 0, -1);
        return ans;
    }
    
    int[] helper(Map<Integer, List<Integer>> adj , int root, int parent) {
        
        int nodeCounts[] = new int[26];
        // Increase count of current character by 1 in alphabet array
        nodeCounts[input.charAt(root)-'a']=1;
        if(adj.get(root)==null) {
        	return nodeCounts;
        } else {
        	List<Integer>l = adj.get(root);
        	int tempNodeCount[] = new int[26];
        	for(int i=0; i<l.size(); i++) {
        		int childRoot = l.get(i);
        		if(parent==childRoot) {
        			continue;
        		}
        		tempNodeCount = helper(adj, childRoot, root);
                // Add the child alphabet array to current array
        	    for(int j=0; j<26; j++) {
        		    nodeCounts[j] += tempNodeCount[j]; 
        	    }
        	}
        	
        	// Create output
        	ans[root] = nodeCounts[input.charAt(root)-'a'];
        	return nodeCounts;
        	
        }
    }

}