class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x,y)->Integer.compare(x[0], y[0]));
        int dir[][] = {{1,0}, {0,-1}, {-1,0}, {0,1}};
        pq.offer(new int[]{grid[0][0],0,0});
        int res = 0;
        boolean[][] seen = new boolean[n][n];
        seen[0][0] = true;
        
        while(!pq.isEmpty()) {
            int top[] = pq.poll();
            res = Math.max(res, top[0]);
            if(top[1]==n-1 && top[2]==n-1) {
                return res;
            }
            for(int d[] : dir) {
                int x = d[0]+top[1];
                int y = d[1]+top[2];
                if(x<n && x>-1 && y<n && y>-1 && !seen[x][y]) {
                    seen[x][y] = true;
                    pq.offer(new int[]{grid[x][y], x, y});
                }
            }
        }
        return -1;
        
    }
}