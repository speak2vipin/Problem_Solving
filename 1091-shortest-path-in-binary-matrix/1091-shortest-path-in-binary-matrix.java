class Solution {
    int N = -1;
    public int shortestPathBinaryMatrix(int[][] grid) {
        N = grid.length;
        int dx[] = {-1, -1, 0, 1, 1,  1,  0, -1};
        int dy[] = { 0,  1, 1, 1, 0, -1, -1, -1};
        Queue<int[]> qe = new LinkedList<>();
        if(grid[0][0]!=0) {
            return -1;
        }
        qe.offer(new int[]{0,0});
        int res = 0;
        while(!qe.isEmpty()) {
            int size = qe.size();
            res++;
            for(int k=0; k<size; k++) {
                int[] top = qe.poll();
                if(top[0]==N-1 && top[1]==N-1) {
                    return res;
                }
                for(int i=0; i<8; i++) {
                    if(isValid(top[0]+dx[i], top[1]+dy[i], grid)) {
                        grid[top[0]+dx[i]][top[1]+dy[i]] = 1;
                        qe.offer(new int[]{top[0]+dx[i], top[1]+dy[i]});
                    }
                }
            }
            
        }
        return -1;
    }
    
    private boolean isValid(int i, int j, int [][]grid) {
        return i>-1 && i<N && j>-1 && j<N && (grid[i][j]==0);
    }
}