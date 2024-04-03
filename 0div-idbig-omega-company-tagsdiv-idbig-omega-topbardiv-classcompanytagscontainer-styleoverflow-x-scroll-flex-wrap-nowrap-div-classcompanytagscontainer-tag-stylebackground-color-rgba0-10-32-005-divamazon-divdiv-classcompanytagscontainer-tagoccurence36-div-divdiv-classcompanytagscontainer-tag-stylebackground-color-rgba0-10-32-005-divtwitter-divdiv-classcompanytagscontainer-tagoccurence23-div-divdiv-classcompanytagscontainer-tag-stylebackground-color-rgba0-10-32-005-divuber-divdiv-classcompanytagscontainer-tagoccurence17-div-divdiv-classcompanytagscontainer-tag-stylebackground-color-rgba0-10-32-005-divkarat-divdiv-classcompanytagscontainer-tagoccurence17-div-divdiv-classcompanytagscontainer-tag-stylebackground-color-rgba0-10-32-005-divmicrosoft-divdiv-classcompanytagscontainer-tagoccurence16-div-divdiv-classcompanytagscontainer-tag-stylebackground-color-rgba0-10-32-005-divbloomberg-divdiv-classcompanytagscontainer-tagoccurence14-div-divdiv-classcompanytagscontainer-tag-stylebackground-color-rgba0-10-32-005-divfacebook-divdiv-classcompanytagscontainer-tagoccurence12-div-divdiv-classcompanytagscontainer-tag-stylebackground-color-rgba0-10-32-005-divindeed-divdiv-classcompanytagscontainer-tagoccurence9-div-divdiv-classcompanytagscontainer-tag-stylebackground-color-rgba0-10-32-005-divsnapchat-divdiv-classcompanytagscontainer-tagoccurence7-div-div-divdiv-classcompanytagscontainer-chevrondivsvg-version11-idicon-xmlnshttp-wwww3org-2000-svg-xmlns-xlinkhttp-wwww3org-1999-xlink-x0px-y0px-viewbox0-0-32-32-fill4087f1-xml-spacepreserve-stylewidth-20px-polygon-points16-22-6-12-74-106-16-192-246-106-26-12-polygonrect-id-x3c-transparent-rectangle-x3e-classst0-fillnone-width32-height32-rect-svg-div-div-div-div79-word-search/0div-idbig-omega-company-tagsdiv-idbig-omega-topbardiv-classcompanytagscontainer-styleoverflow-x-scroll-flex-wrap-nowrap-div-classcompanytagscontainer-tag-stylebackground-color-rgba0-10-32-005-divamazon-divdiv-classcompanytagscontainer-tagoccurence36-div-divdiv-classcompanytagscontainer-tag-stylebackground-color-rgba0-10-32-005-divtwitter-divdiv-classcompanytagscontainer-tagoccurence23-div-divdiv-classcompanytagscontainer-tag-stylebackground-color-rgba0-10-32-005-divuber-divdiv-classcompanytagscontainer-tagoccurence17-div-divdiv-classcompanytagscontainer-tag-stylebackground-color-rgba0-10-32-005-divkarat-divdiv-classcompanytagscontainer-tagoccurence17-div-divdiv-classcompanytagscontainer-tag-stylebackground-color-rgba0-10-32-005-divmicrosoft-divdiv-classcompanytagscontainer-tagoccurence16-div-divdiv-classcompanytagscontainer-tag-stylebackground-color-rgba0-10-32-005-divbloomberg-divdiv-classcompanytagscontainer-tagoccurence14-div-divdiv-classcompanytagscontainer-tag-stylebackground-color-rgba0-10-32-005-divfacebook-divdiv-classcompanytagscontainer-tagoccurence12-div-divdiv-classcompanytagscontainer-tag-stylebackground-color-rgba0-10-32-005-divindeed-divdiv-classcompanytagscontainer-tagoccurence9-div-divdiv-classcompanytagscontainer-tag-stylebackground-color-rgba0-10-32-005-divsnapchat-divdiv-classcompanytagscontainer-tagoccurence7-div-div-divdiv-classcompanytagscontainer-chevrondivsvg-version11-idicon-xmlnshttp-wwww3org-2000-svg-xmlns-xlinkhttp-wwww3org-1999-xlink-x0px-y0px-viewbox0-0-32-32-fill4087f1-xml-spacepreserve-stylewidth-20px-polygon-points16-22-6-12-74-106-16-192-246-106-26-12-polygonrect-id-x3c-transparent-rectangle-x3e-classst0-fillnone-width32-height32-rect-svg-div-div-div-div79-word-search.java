class Solution {
    boolean isExist = false;
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]==word.charAt(0)) {
                    boolean visit[][] = new boolean[board.length][board[0].length];
                    visit[i][j] = true;
                    dfs(i, j, board, word, visit, 0);
                }
            }
        }
        return isExist;
    }
    
    void dfs(int i, int j, char[][]board, String word, boolean visit[][], int index) {
        int n = board.length;
        int m = board[0].length;
        if(index==word.length()-1) {
            isExist = true;
            return;
        }
        
        int dir[][] = {{1,0},{0,-1},{-1,0},{0,1}};
        for(int k=0; k<4; k++) {
            int dx = i + dir[k][0];
            int dy = j + dir[k][1];
            if(dx>-1 && dx<n && dy>-1 && dy<m && !visit[dx][dy] && 
                        board[dx][dy]==word.charAt(index+1)) {
                if(index+1==word.length()-1) {
                    isExist = true;
                    return;
                }
                visit[dx][dy] = true;
                dfs(dx, dy, board, word, visit, index+1);
                visit[dx][dy] = false;
            }
            
        }
    }
        
    
    boolean bfs(int i, int j, char[][]board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean visit[][] = new boolean[n][m];
        Queue<int[]> qe = new ArrayDeque<>();
        qe.offer(new int[]{i, j, 0});
        visit[i][j] = true;
        int dir[][] = {{1,0},{0,-1},{-1,0},{0,1}};
        
        while(!qe.isEmpty()) {
            int size = qe.size();
            for(int k=0; k<size; k++) {
                int top[] = qe.poll();
                for(int l=0; l<4; l++) {
                    int dx = top[0] + dir[l][0];
                    int dy = top[1] + dir[l][1];
                    int index = top[2];
                    if(index==word.length()-1) {
                        return true;
                    }
                    if(dx>-1 && dx<n && dy>-1 && dy<m && !visit[dx][dy] && 
                        board[dx][dy]==word.charAt(index+1)) {
                        visit[dx][dy] = true;
                        qe.offer(new int[]{dx, dy, index+1});
                    }
                }
            }
        }
        return false;
    }
}