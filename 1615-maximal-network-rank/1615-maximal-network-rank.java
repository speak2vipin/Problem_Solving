class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
		Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
		for (int road[] : roads) {
			adj.computeIfAbsent(road[0], val -> new ArrayList<Integer>()).add(road[1]);
			adj.computeIfAbsent(road[1], val -> new ArrayList<Integer>()).add(road[0]);
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			int x = adj.getOrDefault(i, new ArrayList<Integer>()).size();
			for (int j = i + 1; j < n; j++) {
				int y = adj.getOrDefault(j, new ArrayList<Integer>()).size();
				
				if (adj.get(i)!=null && adj.get(i).contains(j)) {
					y = y - 1;
				}
				res = Math.max(res, x + y);
			}
		}
		return res;
	}
}