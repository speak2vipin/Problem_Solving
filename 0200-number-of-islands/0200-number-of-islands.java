class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]=='1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    void bfs(char[][]grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        int dy[] = {-1, 0, 1, 0};
        int dx[] = { 0, 1, 0, -1};
        Queue<int[]> qe = new LinkedList<>();
        qe.offer(new int[]{i, j});
        while(!qe.isEmpty()) {
            int size = qe.size();
            for(int l=0; l<size; l++) {
                int top[] = qe.poll();
                for(int k=0; k<4; k++) {
                    int newI = top[0] + dx[k];
                    int newJ = top[1] + dy[k];
                    if(isValid(newI, newJ, m, n, grid)) {
                        grid[newI][newJ] = '2';
                        qe.offer(new int[]{newI, newJ});
                    } 
                }
            }
        }
    }
    
    boolean isValid(int i, int j, int m, int n, char[][]grid) {
        return i>-1 & i<m && j>-1 && j<n && grid[i][j]=='1';
    }
}