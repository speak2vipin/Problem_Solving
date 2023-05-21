// Logic
    // Mind it
        // U have two islands
    // Find a land
        // DFS to cover all the island i.e. grid[i][j]=1 and enqueued it
    // Exceute BFS to all the nodes and if grid[i+dx][j+dy]==0, enqueued it 
        // Increment distance
        // if grid[i+dx][j+dy]==1 return distance

class Solution {
    
    int xBoundary = -1;
	int yBoundary = -1;
	int dx[] = { -1, 0, 1, 0 };
	int dy[] = { 0, 1, 0, -1 };

	public int shortestBridge(int[][] grid) {
		yBoundary = grid.length;
		xBoundary = grid[0].length;
		int xIndex = -1;
		int yIndex = -1;
		Queue<int[]> qe = new LinkedList<>();
		boolean flag = false;
		for (int i = 0; i < yBoundary; i++) {
			for (int j = 0; j < xBoundary; j++) {
				if (grid[i][j] == 1) {
					xIndex = i;
					yIndex = j;
					flag = true;
					grid[xIndex][yIndex] = 2;
					break;
				}
			}
			if (flag) {
				break;
			}
		}
		
		dfs(xIndex, yIndex, grid, qe);
		
		int distance = 0;

		while (!qe.isEmpty()) {
			// Queue<int[]> qeBfs = new LinkedList<>();
			int size = qe.size();
			for (int j = 0; j < size; j++) {
				int top[] = qe.poll();
				for (int i = 0; i < 4; i++) {
					if (isValid(top[0] + dx[i], top[1] + dy[i])) {
						if (grid[top[0] + dx[i]][top[1] + dy[i]] == 0) {
							qe.offer(new int[] { top[0] + dx[i], top[1] + dy[i] });
							grid[top[0] + dx[i]][top[1] + dy[i]] = -1;
						} else if (grid[top[0] + dx[i]][top[1] + dy[i]] == 1) {
							return distance;
						}
					}
				}
			}
			distance++;
		}
		return distance;
	}

	void dfs(int x, int y, int grid[][], Queue<int[]> qe) {
		qe.offer(new int[] { x, y });
		for (int i = 0; i < 4; i++) {
			if (isValid(x + dx[i], y + dy[i]) && grid[x + dx[i]][y + dy[i]] == 1) {
				qe.offer(new int[] { x + dx[i], y + dy[i] });
				grid[x + dx[i]][y + dy[i]] = 2;
				dfs(x + dx[i], y + dy[i], grid, qe);
			}
		}
	}

	boolean isValid(int x, int y) {
		return x > -1 && x < xBoundary && y > -1 && y < yBoundary;
	}
}