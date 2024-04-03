class Solution {
    
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]==word.charAt(0)) {
                    boolean visit[][] = new boolean[board.length][board[0].length];
                    visit[i][j] = true;
                    if(dfs(i, j, board, word, visit, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    boolean dfs(int i, int j, char[][]board, String word, boolean visit[][], int index) {
        int n = board.length;
        int m = board[0].length;
        if(index==word.length()-1) {
            return true;
        }
        
        int dir[][] = {{1,0},{0,-1},{-1,0},{0,1}};
        for(int k=0; k<4; k++) {
            int dx = i + dir[k][0];
            int dy = j + dir[k][1];
            if(dx>-1 && dx<n && dy>-1 && dy<m && !visit[dx][dy] && 
                        board[dx][dy]==word.charAt(index+1)) {
                visit[dx][dy] = true;
                if(dfs(dx, dy, board, word, visit, index+1)) {
                    return true;
                }
                visit[dx][dy] = false;
            }
        }
        return false;
    }
        
}