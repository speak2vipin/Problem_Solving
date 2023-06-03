class Solution {
    // Logic:
        // Calculate distance between every detonators and check whether it is less then the effect radius of first detonators
        // If it is then there is an edge between those detonators
        // Traverse from all node and check for maximum node on the path
        // Node:
            // Check everynode to every other node except i!=j
            // A can blast B since it has that much radius but vice versa is not true
    
    Map<Integer, List<Integer>> adj = new HashMap<>();
	int count = 0;

	public int maximumDetonation(int[][] bombs) {
		
		int N = bombs.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i==j) {
                    continue;
                }
				int cx1 = bombs[i][0];
				int cy1 = bombs[i][1];
				int r1 = bombs[i][2];
				int cx2 = bombs[j][0];
				int cy2 = bombs[j][1];
				long dist = 1l * (cx1 - cx2) * (cx1 - cx2) + 1l * (cy1 - cy2) * (cy1 - cy2);

				if (1l * r1 * r1 >= dist) {
					adj.computeIfAbsent(i, val -> new ArrayList<Integer>()).add(j);
				} 
	        }
		}

		int answer = 0;
        for (int i = 0; i < N; i++) {
            // U will be checking every node's connecting path to other node's
            // May be A is coming in path B but it may not be coming in the path of C
        	boolean visit[] = new boolean[N];
        	if (!visit[i]) {
				count = 1;
				dfs(i, visit);
				answer = Math.max(answer, count);
        	}
        }
		return answer;
	}	

	void dfs(int node, boolean visit[]) {
		visit[node] = true;
		if (adj.get(node) != null) {
			for (Integer neighbour : adj.get(node)) {
				if (!visit[neighbour]) {
					count++;
					dfs(neighbour, visit);
				}
			}
		}
	}
}