class Solution {
    
    int n = 0;
	int m = 0;

	public int numEnclaves(int[][] grid) {
		n = grid.length;
		m = grid[0].length;
		boolean visit[][] = new boolean[n][m];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1 && !visit[i][j]) {
					ans += bfs(grid, visit, i, j);
				}
			}
		}
		return ans;
	}

	int bfs(int grid[][], boolean visit[][], int i, int j) {
        
		int count = 0;
		boolean isEnclaves = true;
		visit[i][j] = true;
		Queue<int[]> qe = new LinkedList<>();
		qe.offer(new int[] { i, j });
		int dx[] = { -1, 0, 1, 0 };
		int dy[] = { 0, 1, 0, -1 };
		while (!qe.isEmpty()) {
			int top[] = qe.poll();
			int x = top[0];
			int y = top[1];
			
			count++;
			for (int k = 0; k < 4; k++) {
				if (x + dx[k] < 0 || x + dx[k] > n - 1 || y + dy[k] < 0 || y + dy[k] > m - 1) {
					isEnclaves = false;
				} else if (!visit[x + dx[k]][y + dy[k]] && grid[x + dx[k]][y + dy[k]] == 1) {
					visit[x + dx[k]][y + dy[k]] = true;
					qe.offer(new int[] { x + dx[k], y + dy[k] });
				}
			}
		}
		return isEnclaves ? count : 0;
	
	}
}