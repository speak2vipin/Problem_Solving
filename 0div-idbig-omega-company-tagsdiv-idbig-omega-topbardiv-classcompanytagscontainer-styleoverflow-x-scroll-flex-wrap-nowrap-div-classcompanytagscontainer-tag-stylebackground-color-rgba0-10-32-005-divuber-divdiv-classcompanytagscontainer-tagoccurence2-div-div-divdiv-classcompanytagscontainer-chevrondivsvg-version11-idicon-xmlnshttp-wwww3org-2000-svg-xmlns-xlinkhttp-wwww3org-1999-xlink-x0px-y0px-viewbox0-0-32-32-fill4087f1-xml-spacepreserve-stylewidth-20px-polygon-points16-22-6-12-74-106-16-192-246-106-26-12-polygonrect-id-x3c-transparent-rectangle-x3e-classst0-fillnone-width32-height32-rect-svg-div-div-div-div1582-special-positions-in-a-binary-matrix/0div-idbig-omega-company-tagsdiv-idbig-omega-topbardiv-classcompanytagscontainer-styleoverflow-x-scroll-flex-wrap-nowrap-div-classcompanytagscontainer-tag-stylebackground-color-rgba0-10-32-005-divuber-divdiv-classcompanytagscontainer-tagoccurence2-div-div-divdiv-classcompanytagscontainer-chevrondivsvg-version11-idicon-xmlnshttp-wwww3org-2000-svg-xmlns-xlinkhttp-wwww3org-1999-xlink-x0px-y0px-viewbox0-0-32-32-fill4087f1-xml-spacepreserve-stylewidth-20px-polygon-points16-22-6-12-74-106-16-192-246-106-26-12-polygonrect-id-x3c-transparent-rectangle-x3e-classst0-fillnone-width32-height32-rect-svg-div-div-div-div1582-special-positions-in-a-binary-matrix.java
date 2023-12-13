class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;
        int rowCount[] = new int[m]; 
        int colCount[] = new int[n];
         for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j]==1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
         }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j]==1 && rowCount[i]==1 && colCount[j]==1) {
                    ans++;
                } 
            }
        }
        return ans;
    }
    public int numSpecialMy(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;
        Set<Integer>rowset = new HashSet<>();
        Set<Integer>colset = new HashSet<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j]==1 && !rowset.contains(i) && !colset.contains(j)) {
                    
                    int row = 0, col = j;
                    int oneCountRow = 0;
                    int oneCountCol = 0;
                    
                    while(row<m) {
                        if(mat[row][col]==1) {
                            oneCountRow++;
                        }
                        row++;
                    }
                    
                    row = i; col = 0;
                    while(col<n) {
                        if(mat[row][col]==1) {
                            oneCountCol++;
                        }
                        col++;
                    }
                    
                    if(oneCountRow==1 && oneCountCol==1) {
                        ans++;
                    }
                    rowset.add(i);
                    colset.add(j);
                } 
            }
        }
        return ans;
    }
}