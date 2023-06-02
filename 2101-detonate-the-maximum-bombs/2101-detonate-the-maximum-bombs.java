class Solution {
   Map<Integer, List<Integer>> adj = new HashMap<>();
	boolean visit[] = null;
	int count = 0;
	int res = Integer.MIN_VALUE;

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
        	visit = new boolean[N];
        	if (!visit[i]) {
				count = 1;
				dfs(i);
				answer = Math.max(answer, count);
        	}
        }
		return answer;
	}	

	void dfs(int node) {
		visit[node] = true;
		if (adj.get(node) != null) {
			for (Integer neighbour : adj.get(node)) {
				if (!visit[neighbour]) {
					count++;
					dfs(neighbour);
				}
			}
		}
	}
}