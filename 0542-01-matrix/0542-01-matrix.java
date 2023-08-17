class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        Queue<int[]> qe = new LinkedList<>();
        int directions[][] = {{-1,0}, {0,1}, {1,0}, {0,-1}}; 
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j]==0) {
                    qe.offer(new int[]{i,j,0});
                    mat[i][j] = 2;
                }
            }
        }
        int res[][] = new int[m][n];
        while(!qe.isEmpty()) {
            int size = qe.size();
            for(int i=0; i<size; i++) {
                int top[] = qe.poll();
                for(int j=0; j<4; j++) {
                    int dx = top[0] + directions[j][0];
                    int dy = top[1] + directions[j][1];
                    if(isValid_1(dx, dy, m, n, mat)) {
                        res[dx][dy] = top[2] + 1;
                        mat[dx][dy] = 2;
                        qe.offer(new int[] {dx, dy, res[dx][dy]});
                    }
                }
            }
        }
        return res;
    
    }
    
    boolean isValid_1(int i, int j, int m, int n, int mat[][]) {
        return i>-1 && i<m && j>-1 && j<n && mat[i][j]==1;
    }
    boolean isValid_0(int i, int j, int m, int n, int mat[][]) {
        return i>-1 && i<m && j>-1 && j<n && mat[i][j]==0;
    }
}