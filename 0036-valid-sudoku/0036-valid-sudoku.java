class Solution {
    public boolean isValidSudoku(char[][] board) {
	        
	        for(int i=0; i<9; i++) {
	            Set<Character> setX = new HashSet<Character>();
	            Set<Character> setY = new HashSet<Character>();
	            for(int j=0; j<9; j++) {
	                if(board[i][j] == '.' || setX.add(board[i][j])) {
	                	
	                } else {
	                	return false;
	                }
	                
	                if(board[j][i]=='.' || setY.add(board[j][i])) {
	                	continue;
	                } else {
	                	return false;
	                }
	            }
	        }
			for (int k = 0; k < 3; k++) {
				for (int l = 0; l < 3; l++) {
					int temp = 0;
					Set<Character> setZ = new HashSet<Character>();
					for (int j = l * 3; j < (l + 1) * 3; j++) {
						for (int i = k * 3; i < (k + 1) * 3; i++) {
							if (board[i][j] == '.') {
								continue;
							} else if (!setZ.add(board[i][j])) {
								return false;
							}
						}
						temp++;
					}
				}
			}
	        return true;
	        
	        
	    
    }
}