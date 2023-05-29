class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
         
        int N = grid.length;
        int M = grid[0].length;
        int res[][] = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                Set<Integer>topLeft = new HashSet<>();
                for(int x=i-1, y=j-1; x>=0 && y>=0 ; x--, y--) {
                    topLeft.add(grid[x][y]);
                }
                
                Set<Integer>bottomRight = new HashSet<>();
                for(int x=i+1, y=j+1; x<N && y<M ; x++, y++) {
                    bottomRight.add(grid[x][y]);
                }
                res[i][j] = Math.abs(topLeft.size()-bottomRight.size());
            }
        }
        return res;
    }
}