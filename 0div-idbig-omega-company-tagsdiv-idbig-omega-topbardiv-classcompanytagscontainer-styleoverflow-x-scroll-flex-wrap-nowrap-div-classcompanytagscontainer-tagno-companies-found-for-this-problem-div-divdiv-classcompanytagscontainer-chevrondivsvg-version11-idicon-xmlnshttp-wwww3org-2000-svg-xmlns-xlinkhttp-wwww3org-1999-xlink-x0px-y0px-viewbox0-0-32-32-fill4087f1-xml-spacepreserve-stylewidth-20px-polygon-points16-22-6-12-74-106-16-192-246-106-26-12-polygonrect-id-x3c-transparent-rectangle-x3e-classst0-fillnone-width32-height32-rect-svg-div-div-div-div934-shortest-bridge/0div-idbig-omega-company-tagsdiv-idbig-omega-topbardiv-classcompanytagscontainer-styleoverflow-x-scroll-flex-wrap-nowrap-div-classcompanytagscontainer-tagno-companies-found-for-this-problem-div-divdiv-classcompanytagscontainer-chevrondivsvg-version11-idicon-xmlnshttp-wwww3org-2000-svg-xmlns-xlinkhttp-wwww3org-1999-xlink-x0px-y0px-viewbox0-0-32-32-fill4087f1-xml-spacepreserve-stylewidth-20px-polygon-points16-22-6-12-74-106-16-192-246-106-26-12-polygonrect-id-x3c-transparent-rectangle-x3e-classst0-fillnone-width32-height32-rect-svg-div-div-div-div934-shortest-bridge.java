class Solution {
   public int shortestBridge(int[][] grid) {
		int n = grid.length;
		int count = 0;
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					bfs(i, j, grid);
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
		Queue<int[]> qe = new LinkedList<int[]>();
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					qe.offer(new int[] { i, j });
				}
			}
		}
		int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int res = 0;
		while(!qe.isEmpty()) {
			int size = qe.size();
			res++;
			for (int k = 0; k < size; k++) {
				int top[] = qe.poll();
				for (int d[] : dir) {
					int dx = d[0] + top[0];
					int dy = d[1] + top[1];
					if (dx > -1 && dx < n && dy > -1 && dy < n && grid[dx][dy] == 0) {
						grid[dx][dy] = 2;
						qe.offer(new int[] { dx, dy });
					} 
					else if (dx > -1 && dx < n && dy > -1 && dy < n && grid[dx][dy] == 1) {
						return res-1;
					} 
				}
			}
		}
		
		return count-1;

	}

	void bfs(int i, int j, int grid[][]) {
		int n = grid.length;
		Queue<int[]> qe = new LinkedList<int[]>();
		qe.offer(new int[] { i, j });
		grid[i][j] = 2;
		int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		while (!qe.isEmpty()) {
			int size = qe.size();
			for (int k = 0; k < size; k++) {
				int top[] = qe.poll();
				for (int d[] : dir) {
					int dx = d[0] + top[0];
					int dy = d[1] + top[1];
					if (dx > -1 && dx < n && dy > -1 && dy < n && grid[dx][dy] == 1) {
						grid[dx][dy] = 2;
						qe.offer(new int[] { dx, dy });
					} 
				}
			}
		}
	}
    
    
}